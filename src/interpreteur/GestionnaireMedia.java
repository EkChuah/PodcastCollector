package interpreteur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

import gestionBD.Query;

import static sun.swing.MenuItemLayoutHelper.max;

public class GestionnaireMedia {


    public ArrayList<Media> media;
    public ArrayList<Media> listAccueil;
    public ArrayList<Media> recommandation;
    public ArrayList<Media> listTelecharger;
    public ArrayList<Media> listHistorique;
    protected ArrayList<String> listCategorie;
    String id;
    public ArrayList<Media> listDl=new ArrayList<Media>();
    int compteur;
    public ArrayList<Media> listTheme;
    public ArrayList<Media> listAuteur;
    
    
	public GestionnaireMedia() throws SQLException{

	    //////////  SI BD

		this.listCategorie = new ArrayList<String>();
        this.media = new ArrayList<Media>();
        Query mainQuery = new Query();
        mainQuery.connect();
        this.media = mainQuery.remplirArrayMedia();
        this.listCategorie = mainQuery.listeCategory();
        mainQuery.close();

        for (int i = 0; i < listCategorie.size(); i++){
            System.out.println(listCategorie.get(i));
        }

        ////////// SI PAS BD
        //loadXML("flux/fichiersXML.txt");
		
        getListAcceuil();
        compteur=0;
	}


    public /*ArrayList<Media>*/ void loadXML(String file) throws SQLException{

        BufferedReader reader;
        try {
            ///// SI PAS BD

            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int i = 1;
            ArrayList<Media> listMedia = new ArrayList<>();
            while (line != null) {
                HttpDownload requete = new HttpDownload(line,"flux"+ i + ".xml");
                requete.downloadUsingStream();
                Flux f = new Flux();
                listMedia.addAll(f.fluxRadio("flux/flux" + i +".xml"));
                line = reader.readLine();
                i++;
            }
            
            this.media = listMedia;

            
            Query query = new Query();
            query.connect();
            //query.deleteAllTable();
            query.createTablePodCollection();
            query.createTableCategory();
            query.createTableAbonnement();
            for(int k = 0; k < this.media.size(); k++) {
            	query.insertPod( media.get(k) );
            	if (media.get(k) instanceof Video){
                    query.insertCategory(((Video) media.get(k)).getCategory());
                }
                else{
                    query.insertCategory(((Audio) media.get(k)).getCategory());
                }
            }
            reader.close();
            query.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getListAcceuil(){
        ArrayList<Media> listAccueil = new ArrayList<>();

        Random random = new Random();
        ArrayList<Integer> tab = new ArrayList<>();
        for (int i = 0; i < media.size()-1; i++) {
            tab.add(i);
        }
        for (int i=0; i < 16; i++){
            int index = random.nextInt(tab.size());
            listAccueil.add(this.media.get(index));
            tab.remove(index);
        }

        /*for (int i=0; i < 16; i++){
            System.out.println(listAcceuil.get(i).getTitre());
        }*/
        this.listAccueil=listAccueil;
    }

    public void recommandation(Profil profil){
        ArrayList<Media> recom = new ArrayList<>();
        ArrayList<Media> tmp = new ArrayList<>();
        ArrayList<Integer> tab = new ArrayList<>();

        for (int i = 0; i < media.size(); i++){
            if(profil.listeAbonnement.contains(media.get(i).getAuteur()) && !profil.mediaHistorique.contains(media.get(i))){
                tmp.add(media.get(i));
            }
        }
        Random random = new Random();
        for (int i = 0; i < tmp.size()-1; i++) {
            tab.add(i);
        }
        int len = Math.min(16,tmp.size());
        for (int i=0; i < len; i++){
            int index = random.nextInt(tab.size());
            recom.add(tmp.get(index));
            tab.remove(index);
        }
        this.recommandation = recom;
    }

    public void listTelecharger(Profil profil){

        ArrayList<Media> listT = new ArrayList<>();
        int len = Math.min(16,profil.mediaTelecharger.size());
        int lenTel = profil.mediaTelecharger.size();

        for (int i = 0; i < len; i++) {
            listT.add(profil.mediaTelecharger.get(lenTel - i - 1));
        }
        this.listTelecharger = listT;
    }

    public void listHistorique(Profil profil){

        ArrayList<Media> listH = new ArrayList<>();
        int len = Math.min(16,profil.mediaHistorique.size());
        int lenTel = profil.mediaHistorique.size();

        for (int i = 0; i < len; i++) {
            listH.add(profil.mediaHistorique.get(lenTel - i - 1));
        }
        this.listHistorique = listH;
    }

    public void telecharger(Media media){

        compteur++;
        if (media instanceof Video){
            try {
                HttpDownload requete = new HttpDownload(media.getUrl(),media.getAuteur().replaceAll(" ","_")+ compteur+ "." + ((Video) media).getFormat());
                requete.downloadUsingStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String url = media.getAuteur().replaceAll(" ","_");
            media.setUrl("flux/" + url +compteur+ "." + ((Video) media).getFormat());


        }
        else {
            try {
                HttpDownload requete = new HttpDownload(media.getUrl(), media.getAuteur().replaceAll(" ","_") +compteur+ "." + ((Audio) media).getFormat());
                requete.downloadUsingStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String url = media.getAuteur().replaceAll(" ","_");
            media.setUrl("flux/" + url +compteur+ "." + ((Audio) media).getFormat());

        }
        listDl.add(media);
    }


    //Analyser les cat�gories possibles
    //Retourne un ArrayListe de l'ensemble des medias correspondant � la recherche voulue
    public void rechercheCategorie(String categorie){
        ArrayList<Media> resultatRecherche = new ArrayList<Media>();
        ArrayList<Media> tmp = new ArrayList<>();

        if(! this.listCategorie.contains(categorie)) {
            this.listTheme = resultatRecherche;
        }
        else{
            /*
            for(int i = 0; i < media.size() -1; i++) {
                if ( media.get(i) instanceof Video){
                    if( ((Video) media.get(i)).category.equals(categorie)) {
                        tmp.add(media.get(i));
                    }
                }
                else{
                    if( ((Audio) media.get(i)).category.equals(categorie)) {
                        tmp.add(media.get(i));
                    }
                }
            }*/

            Query mainQuery = new Query();
            try {
                mainQuery.connect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tmp = mainQuery.rechercheBDCategory(categorie);
            mainQuery.close();

            ArrayList<Integer> tab = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < tmp.size()-1; i++) {
                tab.add(i);
            }

            for (int i=0; i < 16; i++){
                int index = random.nextInt(tab.size());
                resultatRecherche.add(tmp.get(index));
                tab.remove(index);
            }
            this.listTheme = resultatRecherche;
        }
    }


    public void rechercheAbonnement(String auteur){
        ArrayList<Media> resultatRecherche = new ArrayList<Media>();
        ArrayList<Media> tmp = new ArrayList<>();
        System.out.println(auteur);
        /*
        for(int i = 0; i < media.size() -1; i++) {
            if( media.get(i).getAuteur().equals(auteur)) {
                tmp.add(media.get(i));
            }
        }
        */
        Query mainQuery = new Query();
        try {
            mainQuery.connect();
            tmp = mainQuery.rechercheBDAuteur(auteur);
            mainQuery.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(tmp.size());
        ArrayList<Integer> tab = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < tmp.size()-1; i++) {
            tab.add(i);
        }
        int len = Math.min(16, tmp.size());
        for (int i=0; i < len-1 ; i++){
            int index = random.nextInt(tab.size());
            resultatRecherche.add(tmp.get(index));
            tab.remove(index);
        }
        this.listAuteur = resultatRecherche;
    }



    public Media getMedia(int i){

        return media.get(i);

    }

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }


    public ArrayList<String> getListCategorie(){
        return this.listCategorie;
    }

}

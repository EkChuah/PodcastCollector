package interpreteur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import gestionBD.Query;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
/*
        Date date = Calendar.getInstance().getTime();
        Audio audio = new Audio("Marseille", "JUL", "C'est une chanson", date, "url.mp3","mp3","urlImage.png");
        Video video = new Video("Marseille", "JUL", "C'est un clip mus", date, "url.mp4","mp4");
        System.out.println(audio.toString());
        System.out.println(video.toString());
        Media media = new Media("Marseille", "JUL", "C'est une clip", date, "url.media");
        media.play();
        audio.play();

        System.out.println("************* FLUX VIDEOS YOUTUBE ************");
        Flux f = new Flux();
        ArrayList<Media> listMedia = null;
        listMedia = f.flux("flux/fluxlocal.xml");

        for(int i = 0; i < listMedia.size(); i++) {
            System.out.println("*************MEDIA " + (i+1) +" ************");
            System.out.println(listMedia.get(i).getTitre());
            System.out.println(listMedia.get(i).getAuteur());
            //System.out.println(listMedia.get(i).getDescription());
            System.out.println(listMedia.get(i).getUrl());
        }

        System.out.println("************* FLUX AUDIO FRANCE INTER ************");
        Flux f_radio = new Flux();
        ArrayList<Media> listRadio;
        listRadio =  f_radio.fluxRadio("flux/fluxFranceInter.xml");

        for(int i = 0; i < listRadio.size(); i++) {
            System.out.println("*************MEDIA " + (i + 1) + " ************");
            System.out.println(listRadio.get(i).getTitre());
            System.out.println(listRadio.get(i).getAuteur());
            System.out.println(listRadio.get(i).getDescription());
            System.out.println(listRadio.get(i).getUrl());
            System.out.println(((Audio) listRadio.get(i)).getUrlImage());
        }

        System.out.println("************* Test récupération fichier ************");
        HttpDownload requete = new HttpDownload("http://radiofrance-podcast.net/podcast09/rss_13939.xml","testHTTPRequest.xml");
        requete.downloadUsingStream();
        */

        GestionnaireMedia gest = new GestionnaireMedia();
        ArrayList<Media> listMediaRechercheCategorie = new ArrayList<Media>();
        ArrayList<Media> listMediaRechercheMotCle = new ArrayList<Media>();
        Query query1 = new Query();
        
        query1.connect();
        
        query1.close();
        //verification fonctionnement du remplissage du tableau des categories
        /*
        int size = gest.listCategorie.size();
        for(int k = 0 ; k < size ; k++) {
        	System.out.println(gest.listCategorie.get(k));
        }
        */
        
        /*
        Flux f = new Flux();
        ArrayList<Media> listMedia= f.fluxRadio("flux/flux4.xml");

        for (int j =0; j < listMedia.size(); j++){
            System.out.println( j +" : " + listMedia.get(j).getTitre());
        }*/


        

    }
}

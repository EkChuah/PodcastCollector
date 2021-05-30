package interpreteur;

import gestionBD.Query;

import java.sql.SQLException;

public class GestionnaireProfil {

    private Profil profil;

    public GestionnaireProfil(Profil profil){
        this.profil = profil;

        Query query = new Query();
        try {
            query.connect();
            profil.listeAbonnement = query.listeBDAbonnement();
            query.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public void ecoute(Media media){
        if(!profil.mediaHistorique.contains(media)){
            profil.mediaHistorique.add(media);}
    }

    public void telechargement(Media media){
        profil.mediaTelecharger.add(media);
    }

    public void abonnement(Media media){
        if(!profil.listeAbonnement.contains(media.getAuteur())){
            profil.listeAbonnement.add(media.getAuteur());}
    }


    public Profil getProfil(){
        return profil;
    }
}

package interpreteur;

import java.util.ArrayList;

public class Profil {

    protected String login;
    protected ArrayList<Media> mediaHistorique;
    protected ArrayList<Media> mediaTelecharger;
    protected ArrayList<String> listeAbonnement;

    public Profil(String login){
        this.login = login;
        this.mediaHistorique = new ArrayList<Media>();
        this.mediaTelecharger = new ArrayList<Media>();
        this.listeAbonnement = new ArrayList<String>();
    }

    public ArrayList<Media> getTelecharger(){
        return mediaTelecharger;
    }

    public ArrayList<Media> getHistorique(){
        return mediaHistorique;
    }

    public ArrayList<String> getAbo(){
        return listeAbonnement;
    }

}

package interpreteur;

import java.util.Date;

public class Media {
    protected String titre;
    protected String auteur;
    protected String description;
    protected Date date ;
    protected String url;

    public Media(){
    }

    public Media(String titre, String auteur, String description, Date date, String url) {
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.date = date;
        this.url = url;

    }

    public String getTitre(){
        return this.titre;
    }
    public String getAuteur(){
        return this.auteur;
    }
    public String getDescription(){
        return this.description;
    }
    public Date getDate(){
        return this.date;
    }
    public String getUrl(){
        return this.url;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public void play(){
        System.out.println(" Play : " + getUrl());
    }
}

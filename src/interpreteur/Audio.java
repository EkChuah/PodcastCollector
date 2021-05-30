package interpreteur;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Audio extends Media{

    protected String format;
    protected String urlImage;
    protected String category;
    
    public Audio(String titre, String auteur, String description, Date date, String url, String format, String urlImage, String category) {
        super(titre,auteur,description,date,url);
        this.format = format;
        this.urlImage = urlImage;
        this.category = category;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        return "Audio{" +
                "titre : " + titre +
                ", auteur : " + auteur +
                ", description : " + description +
                ", date : " + strDate +
                ", url : " + url  +
                ", format : " + format  +
                ", urlImage : " + urlImage  +
                ", category : " + category +
                '}';
    }

    public String getFormat(){
        return this.format;
    }

    public void setFormat(String format){
        this.format = format;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category =  category;
    }
    
    
    public String getUrlImage(){ return this.urlImage;}

    public void setUrlImage(String urlImage){ this.urlImage = urlImage;}

}

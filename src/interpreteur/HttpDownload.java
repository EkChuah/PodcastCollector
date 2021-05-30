package interpreteur;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownload {
    private static final int BUFFER_SIZE = 4096;
    private String adresseURL;                                                      //Attribut correspondant à l'adresse URL du fichier à télécharger
    private String name;                                                            //Attribut permettant de stocker l'adresse d'enregistrement du fichier voulu

    public HttpDownload(String s, String s1) {
        this.adresseURL = s;
        this.name = s1;
    }


    public void downloadUsingStream() throws IOException{
        URL url = new URL(this.adresseURL);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        String pathFile = "./flux/" + this.name;
        FileOutputStream fis = new FileOutputStream(pathFile);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
    
    //Fonction verifiant l existence d un fichier
    public int verifExist() {
    	String path = "./flux/" + this.name;
    	File file = new File(path);
    	if(file.exists()) {
    		return 1;
    	}
    	else {
    		return 0;
    	}
    }
}

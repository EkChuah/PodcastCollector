package interpreteur;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Flux
{
	
    public Flux(){
    }

    
    /*
    public ArrayList<Media> flux(String path){

        ArrayList<Media> listMedia = new ArrayList<>();


        //Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try
        {

            // Etape 2 : création d'un parseur

            final DocumentBuilder builder = factory.newDocumentBuilder();


            // Etape 3 : création d'un Document

            final Document document= builder.parse(new File(path));


            // Etape 4 : récupération de l'Element racine

            final Element racine = document.getDocumentElement();


            // Etape 5 : récupération données

            final NodeList racineNoeuds = racine.getChildNodes();
            final int nbRacineNoeuds = racineNoeuds.getLength();

            for (int i = 0; i<nbRacineNoeuds; i++)
            {
                if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE & racineNoeuds.item(i).getNodeName() == "entry")
                {
                    final Element media = (Element) racineNoeuds.item(i);
                    //System.out.println(racineNoeuds.item(i).getNodeName());

                    final Element title = (Element) media.getElementsByTagName("media:title").item(0);
                    final Element author = (Element) media.getElementsByTagName("name").item(0);
                    final Element description = (Element) media.getElementsByTagName("media:description").item(0);
                    final Element uri = (Element) media.getElementsByTagName("link").item(0);


                    //System.out.println("title : " + title.getTextContent());
                    //System.out.println("author : " + author.getTextContent());
                    //System.out.println("description : " + description.getTextContent());
                    //System.out.println("url : " + uri.getAttribute("href"));

                    Date date = Calendar.getInstance().getTime();
                    Video mediajout = new Video(title.getTextContent().trim(), author.getTextContent().trim(), description.getTextContent().trim(), date, uri.getAttribute("href").trim(),"mp4");
                    listMedia.add(mediajout);

                }
            }
        }
        catch (final ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (final SAXException e)
        {
            e.printStackTrace();
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }

        return listMedia;
    }*/

    public ArrayList<Media> fluxRadio(String path){

        ArrayList<Media> listAudio = new ArrayList<>();


        //Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document document = builder.parse(new File(path));
            final Element racine = document.getDocumentElement();
            final NodeList racineNoeuds = racine.getChildNodes();
            final int nbRacineNoeuds = racineNoeuds.getLength();

            for (int j = 0; j < nbRacineNoeuds; j++) {

                final NodeList racineNoeuds2 = racineNoeuds.item(j).getChildNodes();
                final int nbRacineNoeuds2 = racineNoeuds2.getLength();

                String url = "https://portal.comunique-se.com.br/wp-content/uploads/2018/07/potencia-radios-comunitarias-sendo-estudio-990x556.jpg";
                for (int i = 0; i < nbRacineNoeuds2; i++) {
                    if (racineNoeuds2.item(i).getNodeName() == "image") {
                        final Element media = (Element) racineNoeuds2.item(i);
                        final Element im = (Element) media.getElementsByTagName("url").item(0);
                        url = im.getTextContent();
                        //System.out.println("Url image changé : " + url.trim());
                    }
                }

                for (int i = 0; i < nbRacineNoeuds2; i++) {

                    if (racineNoeuds2.item(i).getNodeType() == Node.ELEMENT_NODE & racineNoeuds2.item(i).getNodeName() == "item") {
                    	String nameCategory = "default";
                    	
                    	final Element media = (Element) racineNoeuds2.item(i);

                        final Element title = (Element) media.getElementsByTagName("title").item(0);
                        final Element author = (Element) media.getElementsByTagName("itunes:author").item(0);
                        final Element description = (Element) media.getElementsByTagName("description").item(0);
                        final Element uri = (Element) media.getElementsByTagName("enclosure").item(0);
                        final Element category = (Element) media.getElementsByTagName("category").item(0);
                        
                        if(category != null) {
                        	nameCategory = category.getTextContent();
                  
                        }
                        
                        //System.out.println("title : " + title.getTextContent());
                        //System.out.println("author : " + author.getTextContent());
                        //System.out.println("description : " + description.getTextContent());
                        //System.out.println("url : " + uri.getAttribute("href"));
                        //System.out.println(nameCategory);
                        
                        Media mediajout = new Media();
                        Date date = Calendar.getInstance().getTime();
                        int len = uri.getAttribute("url").length() -1 ;
                        //System.out.println((uri.getAttribute("url" )).charAt(len));//uri.getAttribute(url).length() -1));
                        if ( (uri.getAttribute("url" )).charAt(len) == '3' ){
                            mediajout = new Audio(title.getTextContent().trim(), author.getTextContent().trim(), description.getTextContent().trim(), date, uri.getAttribute("url").trim(), "mp3", url.trim(), nameCategory.trim());
                        }
                        else{

                            mediajout = new Video(title.getTextContent().trim(), author.getTextContent().trim(), description.getTextContent().trim(), date, uri.getAttribute("url").trim(), "mp4", url.trim(), nameCategory.trim());
                        }
                        
                        listAudio.add(mediajout);

                    }
                }

            }
        }
        catch (final ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (final SAXException e)
        {
            e.printStackTrace();
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }

        return listAudio;
    }
}
package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import interpreteur.*;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.print.DocFlavor;

public class AccueilController implements Initializable {
	String id;
	Image def;
	ImageView idef;
	int stop;
	private ArrayList<String> idListe = new ArrayList<>();
	private ArrayList<Label> LabelListe = new ArrayList<>();

	private ArrayList<ImageView> imView = new ArrayList<ImageView>();
	Profil profil= new Profil("Albert");
	GestionnaireProfil gestProfil = new GestionnaireProfil(profil);
	ArrayList<MenuItem> menuListe= new ArrayList<>();
	ArrayList<MenuItem> categListe= new ArrayList<>();
	Boolean tel = false;
	Boolean hist = false;
	Boolean recom = false;
	Boolean accueil=true;
	Boolean cat = false;
	Boolean aut = false;
	@FXML Image imageRien;
	@FXML ImageView Image1;
	@FXML ImageView Image2;
	@FXML ImageView Image3;
	@FXML ImageView Image4;
	@FXML ImageView Image5;
	@FXML ImageView Image6;
	@FXML ImageView Image7;
	@FXML ImageView Image8;
	@FXML ImageView Image9;
	@FXML ImageView Image10;
	@FXML ImageView Image11;
	@FXML ImageView Image12;
	@FXML ImageView Image13;
	@FXML ImageView Image14;
	@FXML ImageView Image15;
	@FXML ImageView Image16;
    @FXML Label L1;
    @FXML Label L2;
    @FXML Label L3;
    @FXML Label L4;
    @FXML Label L5;
    @FXML Label L6;
    @FXML Label L7;
    @FXML Label L8;
    @FXML Label L9;
    @FXML Label L10;
    @FXML Label L11;
    @FXML Label L12;
    @FXML Label L13;
    @FXML Label L14;
    @FXML Label L15;
    @FXML Label L16;
    @FXML MenuItem m1;
	@FXML MenuItem m2;
	@FXML MenuItem m3;
	@FXML MenuItem m4;
	@FXML MenuItem m5;
	@FXML MenuItem c1;
	@FXML MenuItem c2;
	@FXML MenuItem c3;
	@FXML MenuItem c4;
	@FXML MenuItem c5;
	@FXML MenuItem c6;
	@FXML MenuItem c7;
	@FXML MenuItem c8;
	@FXML MenuItem c9;
	@FXML MenuItem c10;


	GestionnaireMedia gest;

	{
		try {
			gest = new GestionnaireMedia();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	Image imageVideo;

	@FXML
	Image imageAudio;

	public void initialize(URL url, ResourceBundle rb) {
		stop = 0;
		imageVideo = Image15.getImage();
		imageRien = Image14.getImage();
		imView.add(Image1);
		idListe.add(Image1.getId());
		imView.add(Image2);
		idListe.add(Image2.getId());
		imView.add(Image3);
		idListe.add(Image3.getId());
		imView.add(Image4);
		idListe.add(Image4.getId());
		imView.add(Image5);
		idListe.add(Image5.getId());
		imView.add(Image6);
		idListe.add(Image6.getId());
		imView.add(Image7);
		idListe.add(Image7.getId());
		imView.add(Image8);
		idListe.add(Image8.getId());
		imView.add(Image9);
		idListe.add(Image9.getId());
		imView.add(Image10);
		idListe.add(Image10.getId());
		imView.add(Image11);
		idListe.add(Image11.getId());
		imView.add(Image12);
		idListe.add(Image12.getId());
		imView.add(Image13);
		idListe.add(Image13.getId());
		imView.add(Image14);
		idListe.add(Image14.getId());
		imView.add(Image15);
		idListe.add(Image15.getId());
		imView.add(Image16);
		idListe.add(Image16.getId());
        LabelListe.add(L1);
        LabelListe.add(L2);
        LabelListe.add(L3);
        LabelListe.add(L4);
        LabelListe.add(L5);
        LabelListe.add(L6);
        LabelListe.add(L7);
        LabelListe.add(L8);
        LabelListe.add(L9);
        LabelListe.add(L10);
        LabelListe.add(L11);
        LabelListe.add(L12);
        LabelListe.add(L13);
        LabelListe.add(L14);
        LabelListe.add(L15);
        LabelListe.add(L16);
        menuListe.add(m1);
		menuListe.add(m2);
		menuListe.add(m3);
		menuListe.add(m4);
		menuListe.add(m5);
		categListe.add(c1);
		categListe.add(c2);
		categListe.add(c3);
		categListe.add(c4);
		categListe.add(c5);
		categListe.add(c6);
		categListe.add(c7);
		categListe.add(c8);
		categListe.add(c9);
		categListe.add(c10);





        for (int i = 0; i < 16; i++) {

            if (i >= gest.listAccueil.size()) {
                imView.get(i).setImage(imageRien);

            } else if (gest.listAccueil.get(i) instanceof Video) {
            	Image image = new Image(((Video)gest.listAccueil.get(i)).getUrlImage(),350,350,true,false);
                imView.get(i).setImage(image);
            } else if (gest.listAccueil.get(i) instanceof Audio) {
                Image image = new Image(((Audio)gest.listAccueil.get(i)).getUrlImage(),350,350,true,false);
                imView.get(i).setImage(image);


            }

            LabelListe.get(i).setText(gest.listAccueil.get(i).getTitre());

        }
    }



	@FXML
	private void AfficheMedia(MouseEvent event) throws IOException {
		if (event.getButton()==MouseButton.PRIMARY) {

			id = ((Node) event.getSource()).getId();
			FXMLLoader loader = new FXMLLoader();
			afficheVideo(hist,tel,recom,cat,aut,event);


		} else {
			ImageView iv = (ImageView) event.getSource();
			def = iv.getImage();
			idef = iv;
			RotateTransition rt = new RotateTransition(Duration.millis(1000), iv);
			rt.setAxis(Rotate.Y_AXIS);
			rt.setFromAngle(0);
			rt.setToAngle(180);
			rt.setInterpolator(Interpolator.LINEAR);
			rt.setCycleCount(1);
			rt.play();
			rt.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					GridPane n = (GridPane) iv.getParent().getParent();
					Integer c = GridPane.getColumnIndex(iv.getParent());
					Integer r = GridPane.getRowIndex(iv.getParent());
					VBox v = new VBox();
					id = ((Node) event.getSource()).getId();
					int num=0;
					for (int i = 0; i < idListe.size(); i++) {
						if(id.equals(idListe.get(i))){
							num=i;
						}

					}
					Label a = new Label("Auteur : \n"+gest.listAccueil.get(num).getAuteur()+"\n");
					Label d = new Label("Description : \n"+gest.listAccueil.get(num).getDescription()+ "\n");
					a.setWrapText(true);
                    d.setWrapText(true);
                    a.setMaxWidth(300);
					d.setMaxWidth(300);
					a.setMaxHeight(100);
					d.setMaxHeight(300);
					v.getChildren().add(a);
					v.getChildren().add(d);
					iv.setOpacity(0);
					if (c == null) {
						c = 0;
					}
					if (r == null) {
						r = 0;
					}
					n.add(v, c, r);
					v.setOnMouseClicked(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent arg0) {
							// TODO Auto-generated method stub
							RotateTransition rt = new RotateTransition(Duration.millis(1000), iv);
							rt.setAxis(Rotate.Y_AXIS);
							rt.setFromAngle(180);
							rt.setToAngle(0);
							rt.setInterpolator(Interpolator.LINEAR);
							rt.setCycleCount(1);
							rt.play();
							v.setOpacity(0);
							n.getChildren().remove(v);
							iv.setRotate(-180);
							iv.setOpacity(100);

						}
					});
				}
			});
		}
	}

	@FXML
	public void backToAcc(Event event) throws IOException {
		accueil=true;
		tel=false;
		recom=false;
		hist=false;
		cat = false;
		aut = false;
		int nb=gest.listAccueil.size();
		for (int i = 0; i < 16; i++) {

			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listAccueil.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listAccueil.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAccueil.get(i).getTitre());
			} else if (gest.listAccueil.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listAccueil.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAccueil.get(i).getTitre());
			}
		}
	}


	@FXML
	public void refresh(Event e) {
		gest.getListAcceuil();
		int nb=gest.listAccueil.size();
		for (int i = 0; i < 16; i++) {

			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listAccueil.get(i) instanceof Video) {
				Image image = new Image(((Video)gest.listAccueil.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAccueil.get(i).getTitre());
			} else if (gest.listAccueil.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listAccueil.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAccueil.get(i).getTitre());
			}
		}

		for(int i=0;i<menuListe.size();i++){
			if(i < gestProfil.getProfil().getAbo().size()){
				menuListe.get(i).setText(gestProfil.getProfil().getAbo().get(i));
				menuListe.get(i).setVisible(true);
				System.out.println(gestProfil.getProfil().getAbo().get(i));

			}
			else{
				menuListe.get(i).setVisible(false);
			}
		}

		for(int i=0;i<categListe.size() ;i++){
			if(i < gest.getListCategorie().size()){
				categListe.get(i).setText(gest.getListCategorie().get(i));
				categListe.get(i).setVisible(true);
			}
			else{
				categListe.get(i).setVisible(false);
			}
		}
	}

	@FXML
	public void telechargement(Event e){
		tel=true;
		recom=false;
		hist=false;
		accueil=false;
		cat = false;
		aut = false;
		gest.listTelecharger(profil);
		int nb=gest.listTelecharger.size();
		for (int i = 0; i < 16; i++) {

			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTelecharger.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTelecharger.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTelecharger.get(i).getTitre());
			} else if (gestProfil.getProfil().getTelecharger().get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTelecharger.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTelecharger.get(i).getTitre());
			}
		}
	}


    @FXML
    public void recommandation(Event e){
        tel=false;
        recom=true;
        hist=false;
        accueil=false;
		cat = false;
		aut = false;
        gest.recommandation(profil);
        int nb=gest.recommandation.size();
        for (int i = 0; i < 16; i++) {

            if (i >= nb) {
                imView.get(i).setImage(imageRien);
                LabelListe.get(i).setText("");
            } else if (gest.recommandation.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.recommandation.get(i)).getUrlImage(),350,350,true,false);
                imView.get(i).setImage(image);
                LabelListe.get(i).setText(gest.recommandation.get(i).getTitre());
            } else if (gest.recommandation.get(i) instanceof Audio) {
                Image image = new Image(((Audio) gest.recommandation.get(i)).getUrlImage(),350,350,true,false);
                imView.get(i).setImage(image);
                LabelListe.get(i).setText(gest.recommandation.get(i).getTitre());
            }
        }
    }



	@FXML
	public void historique(Event e){

		hist=true;
		tel=false;
		recom=false;
		accueil=false;
		cat = false;
		aut = false;
		gest.listHistorique(profil);
		int nb=gest.listHistorique.size();
		for (int i = 0; i < 16; i++) {

			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listHistorique.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listHistorique.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listHistorique.get(i).getTitre());
			} else if (gest.listHistorique.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listHistorique.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listHistorique.get(i).getTitre());
			}

		}
	}

	public void afficheVideo(Boolean hist, Boolean tel, Boolean recom, Boolean cat, Boolean aut, Event event) throws IOException{
		id = ((Node) event.getSource()).getId();
		FXMLLoader loader = new FXMLLoader();
		if(tel){

			int num=0;
			for (int i = 0; i < idListe.size(); i++) {
				if(id.equals(idListe.get(i))){
					num=i;
				}

			}
			if(gest.listTelecharger.get(num) instanceof Video){
				loader.setLocation(getClass().getResource("/Vue/VueMedia.fxml"));
			}
			else{
				loader.setLocation(getClass().getResource("/Vue/VueRadio.fxml"));
			}

			Parent root = loader.load();
			MediaController mediaControl = loader.getController();
			mediaControl.setID(id);
			mediaControl.setList(gest.listTelecharger);
			mediaControl.setListId(idListe);
			mediaControl.setGestionnaireProfil(gestProfil);
			mediaControl.setGestionnaireMedia(gest);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		}
		else if(hist){
			int num=0;
			for (int i = 0; i < idListe.size(); i++) {
				if(id.equals(idListe.get(i))){
					num=i;
				}

			}
			if(gest.listHistorique.get(num) instanceof Video){
				loader.setLocation(getClass().getResource("/Vue/VueMedia.fxml"));
			}
			else{
				loader.setLocation(getClass().getResource("/Vue/VueRadio.fxml"));
			}

			Parent root = loader.load();
			MediaController mediaControl = loader.getController();
			mediaControl.setID(id);
			mediaControl.setList(gest.listHistorique);
			mediaControl.setListId(idListe);
			mediaControl.setGestionnaireProfil(gestProfil);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		}
		else if(recom){
			int num=0;
			for (int i = 0; i < idListe.size(); i++) {
				if(id.equals(idListe.get(i))){
					num=i;
				}

			}
			if(gest.recommandation.get(num) instanceof Video){
				loader.setLocation(getClass().getResource("/Vue/VueMedia.fxml"));
			}
			else{
				loader.setLocation(getClass().getResource("/Vue/VueRadio.fxml"));
			}

			Parent root = loader.load();
			MediaController mediaControl = loader.getController();
			mediaControl.setID(id);
			mediaControl.setList(gest.recommandation);
			mediaControl.setListId(idListe);
			mediaControl.setGestionnaireProfil(gestProfil);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();

		}
		else if(accueil){
			int num=0;
			for (int i = 0; i < idListe.size(); i++) {
				if(id.equals(idListe.get(i))){
					num=i;
				}

			}
			if( gest.listAccueil.get(num)instanceof Video){
				loader.setLocation(getClass().getResource("/Vue/VueMedia.fxml"));
			}
			else{
				loader.setLocation(getClass().getResource("/Vue/VueRadio.fxml"));
			}
			Parent root = loader.load();
			MediaController mediaControl = loader.getController();
			mediaControl.setID(id);
			mediaControl.setList(gest.listAccueil);
			mediaControl.setListId(idListe);
			mediaControl.setGestionnaireProfil(gestProfil);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		}

		else if(cat) {
			int num = 0;
			for (int i = 0; i < idListe.size(); i++) {
				if (id.equals(idListe.get(i))) {
					num = i;
				}

			}
			if (gest.listTheme.get(num) instanceof Video) {
				loader.setLocation(getClass().getResource("/Vue/VueMedia.fxml"));
			} else {
				loader.setLocation(getClass().getResource("/Vue/VueRadio.fxml"));
			}
			Parent root = loader.load();
			MediaController mediaControl = loader.getController();
			mediaControl.setID(id);
			mediaControl.setList(gest.listTheme);
			mediaControl.setListId(idListe);
			mediaControl.setGestionnaireProfil(gestProfil);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();

		}

		else if(aut) {
			int num = 0;
			for (int i = 0; i < idListe.size(); i++) {
				if (id.equals(idListe.get(i))) {
					num = i;
				}

			}
			if (gest.listAuteur.get(num) instanceof Video) {
				loader.setLocation(getClass().getResource("/Vue/VueMedia.fxml"));
			} else {
				loader.setLocation(getClass().getResource("/Vue/VueRadio.fxml"));
			}
			Parent root = loader.load();
			MediaController mediaControl = loader.getController();
			mediaControl.setID(id);
			mediaControl.setList(gest.listAuteur);
			mediaControl.setListId(idListe);
			mediaControl.setGestionnaireProfil(gestProfil);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();

		}
	}

	@FXML
	public void rechercheCategory(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(0));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}


	@FXML
	public void rechercheAuteur(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = false;
		aut = true;
		gest.rechercheAbonnement(profil.getAbo().get(0));
		int nb=gest.listAuteur.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listAuteur.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			} else if (gest.listAuteur.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			}
		}
	}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////   MEME CHOSE 10 FOIS  //////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void rechercheCategory2(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(1));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheCategory3(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(2));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheCategory4(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(3));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheCategory5(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(4));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheCategory6(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(5));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheCategory7(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(6));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheCategory8(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(7));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheCategory9(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(8));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheCategory10(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = true;
		aut = false;
		gest.rechercheCategorie(gest.getListCategorie().get(9));
		int nb=gest.listTheme.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listTheme.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			} else if (gest.listTheme.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listTheme.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listTheme.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheAuteur2(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = false;
		aut = true;
		gest.rechercheAbonnement(profil.getAbo().get(1));
		int nb=gest.listAuteur.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listAuteur.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			} else if (gest.listAuteur.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheAuteur3(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = false;
		aut = true;
		gest.rechercheAbonnement(profil.getAbo().get(2));
		int nb=gest.listAuteur.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listAuteur.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			} else if (gest.listAuteur.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheAuteur4(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = false;
		aut = true;
		gest.rechercheAbonnement(profil.getAbo().get(3));
		int nb=gest.listAuteur.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listAuteur.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			} else if (gest.listAuteur.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			}
		}
	}

	@FXML
	public void rechercheAuteur5(Event e){
		hist=false;
		tel=false;
		recom=false;
		accueil=false;
		cat = false;
		aut = true;
		gest.rechercheAbonnement(profil.getAbo().get(4));
		int nb=gest.listAuteur.size();
		for (int i = 0; i < 16; i++) {
			if (i >= nb) {
				imView.get(i).setImage(imageRien);
				LabelListe.get(i).setText("");
			} else if (gest.listAuteur.get(i) instanceof Video) {
				Image image = new Image(((Video) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			} else if (gest.listAuteur.get(i) instanceof Audio) {
				Image image = new Image(((Audio) gest.listAuteur.get(i)).getUrlImage(),350,350,true,false);
				imView.get(i).setImage(image);
				LabelListe.get(i).setText(gest.listAuteur.get(i).getTitre());
			}
		}
	}



}

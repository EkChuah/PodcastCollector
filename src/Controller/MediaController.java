package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import gestionBD.Query;
import interpreteur.Audio;
import interpreteur.GestionnaireMedia;
import interpreteur.GestionnaireProfil;
import interpreteur.Video;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class MediaController implements Initializable {
	String id;
	ArrayList<interpreteur.Media> liste = new ArrayList<>();
	ArrayList<String> listeId = new ArrayList<>();
	String URL;
	String titre;
	String auteur;
	String description;
	String category;
	String parser = "";
	GestionnaireProfil gestProfil;
	interpreteur.Media media;
	GestionnaireMedia gest=new GestionnaireMedia();
	@FXML
	Label theme;
	@FXML
	Label titreLabel;
	@FXML
	Label auteurLabel;
	@FXML
	Label descriptionLabel;
	@FXML
	ProgressBar progb;
	@FXML
	private MediaView mv;
	@FXML
	private Menu mi;
	@FXML
	private Slider vs;
	MediaPlayer mp;
	Media me;
	int launch=0;
	int th=0;

    public MediaController() throws SQLException {
    }

    @FXML
	private void getPlay(MouseEvent event) {
		if (launch==1) {
			mp.play();

			gestProfil.ecoute(this.media);
		} else {
			gestProfil.ecoute(this.media);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent event) {
					// TODO Auto-generated method stub
					mp.stop();
				}
			});
			launch=1;
			Scanner scan = new Scanner(URL);
			scan.useDelimiter("://");
			parser = scan.next();
			if (parser.equals("http") || parser.equals("https")) {
				me = new Media(URL);
				mp = new MediaPlayer(me);
				mv.setMediaPlayer(mp);
				vs.setValue(mp.getVolume() * 100);
				mp.play();
				mp.currentTimeProperty().addListener(new ChangeListener<Object>() {

					@Override
					public void changed(ObservableValue arg0, Object arg1, Object arg2) {
						// TODO Auto-generated method stub
						progb.setProgress(mp.getCurrentTime().toMillis() / (mp.getTotalDuration().toMillis()));
					}
				});
			} else {
				String path = new File(URL).getAbsolutePath();
				me = new Media(new File(path).toURI().toString());
				mp = new MediaPlayer(me);
				mv.setMediaPlayer(mp);
				vs.setValue(mp.getVolume() * 100);

				mp.play();
				mp.currentTimeProperty().addListener(new ChangeListener<Object>() {

					@Override
					public void changed(ObservableValue arg0, Object arg1, Object arg2) {
						// TODO Auto-generated method stub
						progb.setProgress(mp.getCurrentTime().toMillis() / mp.getTotalDuration().toMillis());
					}
				});
			}
		}
	}

	@FXML
	private void getPause(MouseEvent event) {
		mp.pause();
	}

	@FXML
	private void getStop(MouseEvent event) {
		mp.stop();
	}

	@FXML
	private void getVolume(MouseEvent event) {
		mp.setVolume(vs.getValue() / 100);
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setList(ArrayList<interpreteur.Media> list) {
		this.liste = list;
	}

	public void setListId(ArrayList<String> list) {
		this.listeId = list;
		setInfos(id);
		titreLabel.setWrapText(true);
		descriptionLabel.setWrapText(true);
		auteurLabel.setWrapText(true);
	}

	public void setInfos(String id) {
		int k = 0;
		for (int j = 0; j < 16; j++) {
			if (listeId.get(j).equals(id)) {
				URL = liste.get(k).getUrl();
				titre = liste.get(k).getTitre();
				auteur = liste.get(k).getAuteur();
				if( liste.get(k) instanceof Video){
					category = ((Video) liste.get(k)).getCategory();
				}
				else{
					category = ((Audio) liste.get(k)).getCategory();
				}
				description = liste.get(k).getDescription();
				titreLabel.setText(titre);
				auteurLabel.setText(auteur + "\n\n" + category );
				descriptionLabel.setText(description);
				titreLabel.setMaxWidth(200);
				descriptionLabel.setMaxWidth(400);
				this.media = liste.get(k);

			}
			k += 1;
		}

	}

	public void setGestionnaireProfil(GestionnaireProfil gest) {
		this.gestProfil = gest;
	}

	public void goToTime(MouseEvent e) {
		ProgressBar pb = (ProgressBar) e.getSource();
		pb.setProgress(e.getX() / 500);
		Duration d = new Duration(e.getX() / 500 * mp.getTotalDuration().toMillis());
		mp.seek(d);
	}

	@FXML
	public void ddl(MouseEvent e) {
		gestProfil.telechargement(media);

		gest.telecharger(media);

	}

	@FXML
	public void abo(MouseEvent e) {
    	if(!gestProfil.getProfil().getAbo().contains(media.getAuteur()));{
			gestProfil.abonnement(media);

			Query query = new Query();
			try {
				query.connect();
				query.insertAbonnement(media.getAuteur());
				query.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
	}

	@FXML
	public void changeTheme(MouseEvent e) {
		if (th==0) {
			th=1;
			theme.setText("Dark");
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			Scene scene = ((Label) e.getSource()).getScene();
			scene.getStylesheets().clear();
			scene.getStylesheets().add(getClass().getResource("/Vue/styleMediaDark.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}else {
			th=0;
			theme.setText("Light");
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			Scene scene = ((Label) e.getSource()).getScene();
			scene.getStylesheets().clear();
			scene.getStylesheets().add(getClass().getResource("/Vue/styleMediaLight.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
	}

    public void setGestionnaireMedia(GestionnaireMedia gest){
        this.gest=gest;
    }

}

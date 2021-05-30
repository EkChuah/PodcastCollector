package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ConnectController implements Initializable {
	public MediaPlayer mp;;
	private int width;
	private int height;

	@FXML
	private void goToAcc(MouseEvent e) throws IOException {
		BorderPane bp = (BorderPane) FXMLLoader.load(getClass().getResource("/Vue/Sample.fxml"));
		Scene scene = new Scene(bp);
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		mp.stop();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MediaPlayer mp;
		Media me;
		String URL="./videolocal/noel.mp3";
		String path = new File(URL).getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		setMedia(mp);
		mp.setCycleCount(MediaPlayer.INDEFINITE);
		mp.play();
		// TODO Auto-generated method stub
		
	}
	public void setMedia(MediaPlayer med){
		this.mp=med;
	}

	
}

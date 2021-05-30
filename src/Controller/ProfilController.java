package Controller;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ProfilController {
	@FXML
	public void backToAcc(Event event) throws IOException {
		BorderPane bp=(BorderPane)FXMLLoader.load(getClass().getResource("/Vue/Sample.fxml"));
		Scene scene = new Scene(bp);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	public void goToProfile(Event event) throws IOException {
		BorderPane bp=(BorderPane)FXMLLoader.load(getClass().getResource("/Vue/VueProfil.fxml"));
		Scene scene = new Scene(bp);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void AfficheMedia(MouseEvent event) throws IOException {
		
		BorderPane bp=(BorderPane)FXMLLoader.load(getClass().getResource("/Vue/VueMedia.fxml"));
		Scene scene = new Scene(bp);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}

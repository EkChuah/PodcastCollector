package application;

import java.sql.SQLException;
import java.util.Random;

import javafx.animation.TranslateTransition;
/*
import gestionBD.Connexion;
import gestionBD.Pod;
import gestionBD.Query;*/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws SQLException {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/Vue/VueConnect.fxml"));

			

			
			Screen screen = Screen.getPrimary();
			Rectangle2D bounds = screen.getVisualBounds();
			primaryStage.setTitle("Podcast Collector");
			primaryStage.setX(bounds.getMinX());
			primaryStage.setY(bounds.getMinY());
			primaryStage.setWidth(bounds.getWidth());
			primaryStage.setHeight(bounds.getHeight());
			
			Random random = new Random();
			Circle c[] = new Circle[2000];
			for (int i = 0; i < 2000; i++) {
				c[i] = new Circle(1, 1, 1);
				c[i].setRadius(random.nextDouble() * 3);
				Color color = Color.rgb(255, 255, 255, random.nextDouble());
				c[i].setFill(color);
				root.getChildren().add(c[i]);
				snowing(c[i],(int)primaryStage.getWidth(),(int)primaryStage.getHeight());
			}
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void snowing(Circle c, int width, int height) {

		Random random = new Random();
		c.setCenterX(random.nextInt(width));
		int time = 10 + random.nextInt(10);
		TranslateTransition fall = new TranslateTransition();
		fall.setNode(c);
		fall.setFromY(-200);
		fall.setToY(height + 200);
		fall.setToX(random.nextDouble() * c.getCenterX());
		fall.setDuration(Duration.seconds(time));
		fall.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				snowing(c, width, height);
			}
		});

		fall.play();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

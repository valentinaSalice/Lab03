package it.polito.tdp.spellchecker.controller;

import it.polito.tdp.spellcheker.model.Dictionary;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
            FXMLLoader loader =new FXMLLoader(getClass().getResource("SpellChecker.fxml")); //crea la nostra scena a partire da un file fxml 
			
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Dictionary model =new Dictionary();
			SpellCheckerController controller=(SpellCheckerController)loader.getController();
			controller.setModel(model);
			
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

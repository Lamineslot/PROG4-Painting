package controller;

import javafx.stage.Stage;
import view.PaintingScene;

public class Controller {
	private PaintingScene paintingScene;
	
	public Controller(Stage stage) {
		paintingScene = new PaintingScene(this);
		stage.setScene(paintingScene);
		stage.setTitle("Lamine Slot - Painting");
		stage.setWidth(800);
		stage.setHeight(600);
		stage.setResizable(false);
		stage.centerOnScreen();
	}

}

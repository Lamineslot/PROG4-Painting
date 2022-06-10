package controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		new Controller(stage);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

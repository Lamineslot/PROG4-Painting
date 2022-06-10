package view;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class AirPane extends BorderPane {
	
	public AirPane() {
		// setting size and background
		setMinSize(800, 300);
		setMaxSize(800, 300);
		setBackground(new Background(new BackgroundFill(Color.SKYBLUE, null, null)));
		
	}

}

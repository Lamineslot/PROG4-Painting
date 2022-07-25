package view;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class PaintingPane extends BorderPane {

	public PaintingPane() {

		// setting size and background
		setMinSize(800, 300);
		setMaxSize(800, 300);
		setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));

	}
	

}

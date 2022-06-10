package view;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class PaintingPane extends BorderPane {
	private LeafTreePainter leafTreePainter;
	private PineTreePainter pineTreePainter;
	
	public PaintingPane() {
		// initializing instance variables
		leafTreePainter = new LeafTreePainter();
		pineTreePainter = new PineTreePainter();
		
		// setting size and background
		setMinSize(800, 300);
		setMaxSize(800, 300);
		setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
	}

}

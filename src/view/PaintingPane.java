package view;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class PaintingPane extends BorderPane {
	private LeafTreePainter leafTreePainter;
	private PineTreePainter pineTreePainter;

	
	public PaintingPane() {
		// initializing instance variables
		leafTreePainter = new LeafTreePainter(this);
		pineTreePainter = new PineTreePainter(this);
		
		
		// setting size and background
		setMinSize(800, 300);
		setMaxSize(800, 300);
		setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		
	
	
	}
	

}

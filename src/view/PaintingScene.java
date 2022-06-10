package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PaintingScene extends Scene { 
	private Controller controller;

	private BorderPane root;
	private AirPane airPane;
	private PaintingPane paintingPane;
	
	public PaintingScene(Controller controller) {
		super(new Pane(), 800, 600);
		
		// Initializing instance variables
		this.controller = controller;
		root = new BorderPane();
		airPane = new AirPane();
		paintingPane = new PaintingPane();
		
		
		// adding child nodes to root
		root.setCenter(airPane);
		root.setBottom(paintingPane);
		
		// setting the root
		setRoot(root);
		
	}
	
	public void drawAllTrees() {
		
	}

}

package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Tree;

public class PaintingScene extends Scene { 
	private Controller controller;
	private LeafTreePainter leafTreePainter;
	private PineTreePainter pineTreePainter;
	private BorderPane root;
	private AirPane airPane;
	private PaintingPane paintingPane;
	private MenuPane menuPane;
	
	public PaintingScene(Controller controller) {
		super(new Pane(), 800, 600);
		
		// Initializing instance variables
		this.controller = controller;	
		root = new BorderPane();
		airPane = new AirPane();
		paintingPane = new PaintingPane();
		leafTreePainter = new LeafTreePainter(paintingPane);
		pineTreePainter = new PineTreePainter(paintingPane);
		menuPane = new MenuPane(controller);
		
		
		// adding child nodes to root
		root.setTop(menuPane);
		root.setCenter(airPane);
		root.setBottom(paintingPane);
		
		// setting the root
		setRoot(root);
		
	}
	
	
	public void drawTree(Tree tree) {
		switch (tree.getType()) {
		case LEAF:
			leafTreePainter.paintTree(tree);
			break;
		case PINE:
			pineTreePainter.paintTree(tree);
			break;

		
		}
		
	}
	
	public void clear() {
		paintingPane.getChildren().clear();
	}
}

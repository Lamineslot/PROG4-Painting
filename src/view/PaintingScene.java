package view;

import controller.BirdController;
import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Tree;

public class PaintingScene extends Scene {
	private Controller controller;
	private LeafTreePainter leafTreePainter;
	private PineTreePainter pineTreePainter;
	private BorderPane root;
	private AirPane airPane;
	private PaintingPane paintingPane;
	private MenuPane menuPane;

	private Text autograph;

	public PaintingScene(Controller controller, BirdController birdController) {
		super(new Pane(), 800, 600);

		// Initializing instance variables
		this.controller = controller;
		root = new BorderPane();
		airPane = new AirPane();
		paintingPane = new PaintingPane();
		leafTreePainter = new LeafTreePainter(paintingPane, controller);
		pineTreePainter = new PineTreePainter(paintingPane, controller);
		menuPane = new MenuPane(controller, birdController);
		
		// set up autograph
		autograph = new Text("Lamine Slot");
		autograph.setFill(Color.WHITE);		
		
		
		// adding child nodes to root
		root.setTop(menuPane);
		root.setCenter(airPane);
		root.setBottom(paintingPane);

		// setting the root
		setRoot(root);

	}

	/**
	 * Helper method for determining which specific treePainter should be used based
	 * on the type of the tree.
	 * 
	 * @param tree A {@linkplain Tree} object that is supposed to be painted.
	 */
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

	/**
	 * Adds an autograph with my name to the scene.
	 * 
	 * @param font the font that is supposed to be applied to the text
	 */
	public void addAutoGraph(Font font) {
		autograph.setFont(font);
		paintingPane.getChildren().remove(autograph);
		paintingPane.setCenter(autograph);
	}

	public CheckMenuItem getPlayButton() {
		return menuPane.getPlayButton();
	}

	public AirPane getAirPane() {
		return airPane;
	}

	/**
	 * Removes all children of paintingPane, in case paitingPane is not passed on to
	 * a certain object.
	 */
	public void clear() {
		paintingPane.getChildren().clear();
	}

}

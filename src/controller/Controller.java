package controller;

import java.util.Random;

import javafx.stage.Stage;
import model.Tree;
import model.TreeSize;
import model.TreeType;
import model.World;
import view.PaintingScene;

public class Controller {
	private PaintingScene paintingScene;
	private World world;

	public Controller(Stage stage) {
		paintingScene = new PaintingScene(this);
		world = new World();
		stage.setScene(paintingScene);
		stage.setTitle("Lamine Slot - Painting");
		stage.setWidth(800);
		stage.setHeight(600);
		stage.setResizable(false);
		stage.centerOnScreen();
	}

	/**
	 * Adds a random {@link Tree} of type Leaf to the ArrayList in {@link World} and draws it.
	 */
	public void addLeafTree() {
		paintingScene.drawTree(world.addTree("leaf"));
	}
	
	public void addPineTree() {
		world.addTree("pine");
		drawAllTrees();
	}
	
	public void drawRandomTrees() {
		int i = 0;
		while (i < 100) {
			if (new Random().nextBoolean()) {
				addLeafTree();
			} else {
				addLeafTree();
			}
			i++;
		}
	}
	
	public void drawAllTrees() {
		paintingScene.clear();
		for (Tree tree : world.getAllTrees()) {
			paintingScene.drawTree(tree);
		}
	}
	
	public void clearAllTrees() {
		paintingScene.clear();
		world.getAllTrees().clear();
		drawAllTrees();
		
	}
	
	public void moveTrees() {
		world.moveTrees();
	}

}

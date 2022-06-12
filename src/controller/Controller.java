package controller;

import java.util.Collections;
import java.util.Random;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import model.Tree;
import model.World;
import view.MyPopup;
import view.PaintingScene;

public class Controller {
	private PaintingScene paintingScene;
	private Stage stage;
	private World world;
	private FileIO fileIO;
	private Task<Void> playFilm;

	public Controller(Stage stage) {
		paintingScene = new PaintingScene(this);
		world = new World();
		fileIO = new FileIO(this, paintingScene, world);
		this.stage = stage;
		stage.setScene(paintingScene);
		stage.setTitle("Lamine Slot - Painting");
		stage.setWidth(800);
		stage.setHeight(600);
		stage.setResizable(false);
		stage.centerOnScreen();
	}

	/**
	 * Adds a random {@link Tree} of type Leaf to the ArrayList in {@link World} and
	 * draws it.
	 */
	public void addLeafTree() {
		world.addTree("leaf");
		drawAllTrees();
	}

	/**
	 * Adds a random {@link Tree} of type Pine to the ArrayList in {@link World} and
	 * draws it.
	 */
	public void addPineTree() {
		world.addTree("pine");
		drawAllTrees();
	}

	/**
	 * Adds a specific, pre-made {@link Tree} to the ArrayList in {@link World} and
	 * draws it.
	 * 
	 * @param tree A fully implemented {@link Tree} object
	 */
	public void addTree(Tree tree) {
		world.addExistingTree(tree);
		drawAllTrees();
	}

	/**
	 * Draws 100 random trees
	 */
	public void drawRandomTrees() {
		int i = 0;
		while (i < 100) {
			if (new Random().nextBoolean()) {
				addLeafTree();
			} else {
				addPineTree();
			}
			i++;
		}
	}

	/**
	 * Clears all current nodes of paintingScene, sorts the ArrayList of trees based
	 * on relY and draws them in order.
	 */
	public void drawAllTrees() {
		paintingScene.clear();
		Collections.sort(world.getAllTrees());
		for (Tree tree : world.getAllTrees()) {
			paintingScene.drawTree(tree);
		}
	}

	/**
	 * Clears all nodes of paintingScene and removes all trees from the ArrayList in
	 * {@link World}.
	 */
	public void clearAllTrees() {
		paintingScene.clear();
		world.getAllTrees().clear();
		drawAllTrees();

	}

	/**
	 * Calls the moveTrees method in {@link World}. Allows the view to call this
	 * method.
	 */
	private void moveTrees() {
		world.moveTrees();
	}

	/**
	 * Calls the openFile method in {@link FileIO}. Allows the view to call this
	 * method.
	 */
	public void openFile() {
		fileIO.openFile();
	}

	/**
	 * Calls the saveFile method in {@link FileIo}. Allows the view to call this
	 * method.
	 */
	public void saveFile() {
		fileIO.saveFile();
	}

	/**
	 * Creates an object of {@link MyPopup} and adds it to the stage.
	 * 
	 * @param text A string to be displayed as the pop-up text.
	 */
	public void addPopup(String text) {
		MyPopup popup = new MyPopup(text);
		popup.show(stage);

	}

	/**
	 * Calls the setupTask method, creates a new Thread and starts the thread. Plays
	 * the film (moving of trees).
	 */
	public void startTask() {
		setupTask();
		Thread thread = new Thread(playFilm);
		thread.setDaemon(true);
		thread.start();
	}

	/**
	 * Sets up the task that moves all trees and draws them. Makes use of the
	 * runLater method of {@link Platform} to actually draw the trees on the canvas.
	 */
	private void setupTask() {
		playFilm = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				while (paintingScene.getPlayButton().isSelected()) {
					moveTrees();
					Platform.runLater(() -> {
						drawAllTrees();
					});

					Thread.sleep(42);
				}
				return null;
			}
		};
	}

}

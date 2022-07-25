package controller;

import java.util.Collections;
import java.util.Random;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Fonts;
import model.Tree;
import model.TreeType;
import model.World;
import view.PaintingScene;

public class Controller {
	private PaintingScene paintingScene;
	private Stage stage;
	private World world;
	private FileIO fileIO;
	private Task<Void> playFilm;
	private BirdController birdController;
	private Font font;

	public Controller(Stage stage) {

		paintingScene = new PaintingScene(this, birdController);
		world = new World();
		fileIO = new FileIO(this, paintingScene, world);
		birdController = new BirdController(paintingScene);
		font = null;
		this.stage = stage;
		stage.setScene(paintingScene);
		stage.setTitle("Lamine Slot - Painting");
		stage.setResizable(false);
		stage.centerOnScreen();
	}

	/**
	 * Adds a random {@link Tree} of type Leaf to the ArrayList in {@link World} and
	 * draws it.
	 */
	public void addLeafTree() {
		world.addTree(TreeType.LEAF);
		drawAllTrees();
	}

	/**
	 * Adds a random {@link Tree} of type Pine to the ArrayList in {@link World} and
	 * draws it.
	 */
	public void addPineTree() {
		world.addTree(TreeType.PINE);
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
	 * Used to remove an existing tree from the world.
	 * 
	 * @param tree
	 */
	public void removeTree(Tree tree) {
		world.removeTree(tree);
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
	 * Calls the setupTask method, creates a new Thread and starts the thread. Plays
	 * the film (moving of trees).
	 */
	public void startTask() {
		setupTask();
		Thread filmThread = new Thread(playFilm);
		filmThread.setDaemon(true);
		filmThread.start();
	}

	/**
	 * Sets up the task that moves all trees and draws them. Makes use of the
	 * runLater method of {@link Platform} to actually draw the trees on the canvas.
	 */
	private void setupTask() {
		playFilm = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				// if the duck is shown, the movie may not be stopped
				if (birdController.getDuck().isShown()) {
					paintingScene.getPlayButton().setSelected(true);
					return null;
				}

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

	/**
	 * Selects the right Font and adds the autograph to the scene.
	 * 
	 * @param fontType
	 */
	public void addAutoGraph(Fonts fontType) {
		switch (fontType) {
		case GREAT_VIBES:
			font = Font.loadFont(getClass().getResource("/fonts/GreatVibes.ttf").toString(), 15);
			break;
		case HANDDNA:
			font = Font.loadFont(getClass().getResource("/fonts/handdna.ttf").toString(), 15);
			break;
		case HOMEMADE_APPLE:
			font = Font.loadFont(getClass().getResource("/fonts/HomemadeApple.ttf").toString(), 15);
			break;
		case LECKERLI_ONE:
			font = Font.loadFont(getClass().getResource("/fonts/LeckerliOne.ttf").toString(), 15);
			break;
		default:
			font = Font.font("Arial", 15);
			break;
		}
		paintingScene.addAutoGraph(font);
	}

}

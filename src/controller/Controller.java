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

	public void addPineTree() {
		world.addTree("pine");
		drawAllTrees();
	}

	public void addTree(Tree tree) {
		world.addExistingTree(tree);
		drawAllTrees();
	}

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

	public void drawAllTrees() {
		paintingScene.clear();
		Collections.sort(world.getAllTrees());
		for (Tree tree : world.getAllTrees()) {
			paintingScene.drawTree(tree);
		}
	}

	public void clearAllTrees() {
		paintingScene.clear();
		world.getAllTrees().clear();
		drawAllTrees();

	}

	private void moveTrees() {
		world.moveTrees();
	}

	public void openFile() {
		fileIO.openFile();
	}

	public void saveFile() {
		fileIO.saveFile();
	}

	public void addPopup(String text) {
		MyPopup popup = new MyPopup(text);
		popup.show(stage);

	}
	
	public void startTask() {
		setupTask();
		Thread thread = new Thread(playFilm);
		thread.setDaemon(true);
		thread.start();
	}

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

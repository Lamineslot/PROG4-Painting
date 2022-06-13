package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Tree;
import model.TreeSize;
import model.TreeType;
import model.World;
import view.PaintingScene;

public class FileIO {
	private FileChooser chooser;
	private PaintingScene paintingScene;
	private BufferedReader reader;
	private Controller controller;
	private World world;
	private BufferedWriter writer;

	public FileIO(Controller controller, PaintingScene paintingScene, World world) {
		// initializing instance variables
		chooser = new FileChooser();
		this.paintingScene = paintingScene;
		this.controller = controller;
		this.world = world;

		// setting up chooser
		chooser.getExtensionFilters().add(new ExtensionFilter("Paintings", "*.painting"));
		File path = new File("Resources/paintings");
		chooser.initialDirectoryProperty().set(path);
	}

	/**
	 * Opens a system explorer window where the user can select a file. The file is
	 * read and for every line, a {@link Tree} object is created and drawn.
	 */
	public void openFile() {
		File file = chooser.showOpenDialog(paintingScene.getWindow());
		if (file == null) {
			return;
		}

		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {

		}
		// clears all current trees before drawing new ones
		controller.clearAllTrees();

		String line;
		try {
			while ((line = reader.readLine()) != null) {
				// splits the current line and transforms it into a String array. Accesses all
				// the objects in the array and transforms them into usable objects using
				// parsing.
				String[] tree = line.split(":");
				TreeSize treeSize = TreeSize.fromString(tree[1]);
				TreeType treeType = TreeType.fromString(tree[0]);
				double relX = Double.parseDouble(tree[2]);
				double relY = Double.parseDouble(tree[3]);

				// if-statement to check if the current line is valid. If not, it doesn't
				// actually add the tree.
				if (treeSize != null && treeType != null && relX >= 0 && relX <= 100 && relY >= 50 && relY <= 100) {
					controller.addTree(new Tree(treeSize, treeType, relX, relY));
				}
			}
		} catch (IOException e) {
		}

	}

	/**
	 * Opens a system explorer window where the user can save a file. The trees that
	 * are currently drawn are converted into a format and saved in the file.
	 */
	public void saveFile() {
		File file = chooser.showSaveDialog(paintingScene.getWindow());
		if (file == null) {
			return;
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
				writer = new BufferedWriter(new FileWriter(file));
				for (Tree tree : world.getAllTrees()) {
					// gets all the variables of the tree and add them as a line in the file in the layout <type>:<size>:<relX>:<relY>
					writer.write(TreeType.toString(tree.getType()) + ":" + TreeSize.toString(tree.getSize()) + ":"
							+ (int) tree.getRelX() + ":" + (int) tree.getRelY() + "\r\n");
				}
				writer.close();
			} catch (IOException e) {

			}
		}

	}

}

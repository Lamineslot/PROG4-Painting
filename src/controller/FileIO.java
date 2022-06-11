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
		chooser = new FileChooser();
		this.paintingScene = paintingScene;
		this.controller = controller;
		this.world = world;
		chooser.getExtensionFilters().add(new ExtensionFilter("Paintings", "*.painting"));
		File path = new File("Resources/paintings");
		chooser.initialDirectoryProperty().set(path);
	}

	public void openFile() {
		controller.clearAllTrees();
		File file = chooser.showOpenDialog(paintingScene.getWindow());
		if (file == null) {
			return;
		}

		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			controller.addPopup("Unable to read file");
		}
		
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				String[] tree = line.split(":");
				controller.addTree(new Tree(TreeSize.fromString(tree[1]), TreeType.fromString(tree[0]), Double.valueOf(tree[2]), Double.valueOf(tree[3])));
			}
		} catch (IOException e) {
			controller.addPopup("Unable to read file");
		}

	}

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
					writer.write(TreeType.toString(tree.getType()) + ":" + TreeSize.toString(tree.getSize()) + ":" + (int) tree.getRelX() + ":" + (int) tree.getRelY() + "\r\n");
				}
				writer.close();
			} catch (IOException e) {
				
				
			}
		}
		
	}

}

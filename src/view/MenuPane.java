package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;

public class MenuPane extends HBox {
	private Controller controller;
	private MenuBar menuBar;
	private Menu file;
	private Menu tree;
	private Menu movie;
	private MenuItem loadPainting;
	private MenuItem savePainting;
	private MenuItem exit;
	private MenuItem addLeafTree;
	private MenuItem addPineTree;
	private MenuItem addRandomTrees;
	private MenuItem clearAllTrees;
	private CheckMenuItem play;
	
	public MenuPane(Controller controller) {
		// initializing instance variables
		this.controller = controller;
		
		// setting size and background
		setMinSize(600, 30);
		setMaxSize(600, 30);
		
		// creating menubar
		menuBar = new MenuBar();
		
		// creating menu's
		file = new Menu("File");
		tree = new Menu("Tree");
		movie = new Menu("Movie");
		
		// creating menu items
		loadPainting = new MenuItem("Load painting");
		savePainting = new MenuItem("Save painting");
		exit = new MenuItem("Exit");
		addLeafTree = new MenuItem("Add leaf tree");
		addPineTree = new MenuItem("Add pine tree");
		addRandomTrees = new MenuItem("Add random trees");
		clearAllTrees = new MenuItem("Clear all trees");
		play = new CheckMenuItem("Play");
		
		// adding menu items to menu's
		file.getItems().addAll(loadPainting, savePainting, exit);
		tree.getItems().addAll(addLeafTree, addPineTree, addRandomTrees, clearAllTrees);
		movie.getItems().add(play);
		
		// adding menu's to menu bar
		menuBar.getMenus().addAll(file, tree, movie);
		
		getChildren().add(menuBar);
		
		// actionhandlers for menuitems
		exit.setOnAction(e -> Platform.exit());
		addLeafTree.setOnAction(e -> controller.addLeafTree());
		addPineTree.setOnAction(e -> controller.addPineTree());
		clearAllTrees.setOnAction(e -> controller.clearAllTrees());
		addRandomTrees.setOnAction(e -> controller.drawRandomTrees());
		
	}
	
	

}

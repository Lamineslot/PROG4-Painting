package view;

import controller.BirdController;
import controller.Controller;
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import model.Fonts;

public class MenuPane extends HBox {
	// controllers
	private Controller controller;
	private BirdController birdController;
	
	// items for menu's
	private MenuBar menuBar;
	private Menu file;
	private Menu tree;
	private Menu autograph;
	private Menu movie;
	private MenuItem loadPainting;
	private MenuItem savePainting;
	private MenuItem exit;
	private MenuItem addLeafTree;
	private MenuItem addPineTree;
	private MenuItem addRandomTrees;
	private MenuItem clearAllTrees;
	private CheckMenuItem play;
	private RadioMenuItem greatVibesFont;
	private RadioMenuItem handdnaFont;
	private RadioMenuItem homeMadeAppleFont;
	private RadioMenuItem leckerliOneFont;
	private ToggleGroup tg; 
	
	public MenuPane(Controller controller, BirdController birdController) {
		// initializing instance variables
		this.controller = controller;
		this.birdController = birdController;
		// setting size and background
		setMinSize(600, 30);
		setMaxSize(600, 30);
		
		// creating menubar
		menuBar = new MenuBar();
		
		// creating menu's
		file = new Menu("File");
		tree = new Menu("Tree");
		autograph = new Menu("Autograph font");
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
		greatVibesFont = new RadioMenuItem("Great Vibes");
		handdnaFont = new RadioMenuItem("Handdna");
		homeMadeAppleFont = new RadioMenuItem("Homemade Apple");
		leckerliOneFont = new RadioMenuItem("Leckerli one");
		tg = new ToggleGroup();
		
		// setting toggle group for font items
		greatVibesFont.setToggleGroup(tg);
		handdnaFont.setToggleGroup(tg);
		homeMadeAppleFont.setToggleGroup(tg);
		leckerliOneFont.setToggleGroup(tg);
		
		// adding menu items to menu's
		file.getItems().addAll(loadPainting, savePainting, exit);
		tree.getItems().addAll(addLeafTree, addPineTree, addRandomTrees, clearAllTrees);
		movie.getItems().add(play);
		autograph.getItems().addAll(greatVibesFont, handdnaFont, homeMadeAppleFont, leckerliOneFont);
		
		// adding menu's to menu bar
		menuBar.getMenus().addAll(file, tree, autograph, movie);
		
		getChildren().add(menuBar);
		
		// actionhandlers for menuitems
		exit.setOnAction(e -> Platform.exit());
		addLeafTree.setOnAction(e -> controller.addLeafTree());
		addPineTree.setOnAction(e -> controller.addPineTree());
		clearAllTrees.setOnAction(e -> controller.clearAllTrees());
		addRandomTrees.setOnAction(e -> controller.drawRandomTrees());
		loadPainting.setOnAction(e -> controller.openFile());
		savePainting.setOnAction(e -> controller.saveFile());
		play.setOnAction(e -> controller.startTask());
		
		// fonts
		greatVibesFont.setOnAction(e -> controller.addAutoGraph(Fonts.GREAT_VIBES));
		handdnaFont.setOnAction(e -> controller.addAutoGraph(Fonts.HANDDNA));
		homeMadeAppleFont.setOnAction(e -> controller.addAutoGraph(Fonts.HOMEMADE_APPLE));
		leckerliOneFont.setOnAction(e -> controller.addAutoGraph(Fonts.LECKERLI_ONE));
		
	}
	
	public CheckMenuItem getPlayButton() {
		return play;
	}
	
	

}

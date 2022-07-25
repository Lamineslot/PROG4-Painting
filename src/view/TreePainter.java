package view;

import controller.Controller;
import javafx.scene.paint.Color;
import model.Tree;

public abstract class TreePainter {
	protected PaintingPane paintingPane;
	protected Controller controller;

	protected TreePainter(PaintingPane paintingPane, Controller controller) {
		this.paintingPane = paintingPane;
		this.controller = controller;
	}

	public abstract void paintTree(Tree tree);

	/**
	 * Helper method for calculating the relative size based on the size of a {@linkplain Tree}. 
	 * @param tree A {@linkplain Tree} object to calculate the size for
	 * @return the relative size that is used to calculate the offsets of the tree.
	 */
	public double calculateRelativeSize(Tree tree) {
		switch (tree.getSize()) {
		case S:
			return 0.5;
		case M:
			return 0.6;
		case L:
			return 0.7;
		case XL:
			return 0.8;
		case XXL:
			return 1;
		default:
			return 0;

		}
	}

	/**
	 * Helper method for calculating the color based on the size of a {@linkplain Tree}.
	 * @param tree A {@linkplain Tree} object to decide the color for.
	 * @return the color that is used to set the crown of the tree.
	 */
	public Color decideColor(Tree tree) {
		switch (tree.getSize()) {
		case S:
			return Color.YELLOWGREEN;
		case M:
			return Color.LAWNGREEN;
		case L:
			return Color.FORESTGREEN;
		case XL:
			return Color.GREEN;
		case XXL:
			return Color.DARKGREEN;
		default:
			return Color.TRANSPARENT;

		}
	}
}

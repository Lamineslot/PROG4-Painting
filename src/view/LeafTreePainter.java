package view;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Tree;

public class LeafTreePainter extends TreePainter {
	private PaintingPane paintingPane;

	public LeafTreePainter(PaintingPane paintingPane) {
		super(paintingPane);
		this.paintingPane = paintingPane;

	}

	@Override
	public void paintTree(Tree tree) {
		Circle circle = new Circle();

		// sets the size based on the size (S, M, L etc) of the tree
		double relativeSize = -1;

		switch (tree.getSize()) {
		case S:
			circle.setFill(Color.GREENYELLOW);
			relativeSize = 0.5;
			break;
		case M:
			circle.setFill(Color.LAWNGREEN);
			relativeSize = 0.6;
			break;
		case L:
			circle.setFill(Color.FORESTGREEN);
			relativeSize = 0.7;
			break;
		case XL:
			circle.setFill(Color.GREEN);
			relativeSize = 0.8;
			break;
		case XXL:
			circle.setFill(Color.DARKGREEN);
			relativeSize = 1;
			break;
		default:
			break;

		}

		double radius = relativeSize * 5 * (tree.getRelY() / 10) - 10;
		circle.setRadius(radius);

		circle.setCenterX(tree.getRelX() + (0 + new Random().nextInt(650 - 0 + 1)));

		circle.setCenterY(tree.getRelY() + (-10 + new Random().nextInt(130 - -10 + 1)));

		circle.setStroke(Color.BLACK);

		Rectangle trunk = new Rectangle(circle.getCenterX() - 6, circle.getCenterY() + radius, radius / 2, radius);
		trunk.setStroke(Color.BLACK);
		trunk.setFill(Color.SADDLEBROWN);

		paintingPane.getChildren().addAll(circle, trunk);

	}

}

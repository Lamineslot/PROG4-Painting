package view;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import model.Tree;

public class PineTreePainter extends TreePainter {
	private PaintingPane paintingPane;

	public PineTreePainter(PaintingPane paintingPane) {
		super(paintingPane);
		this.paintingPane = paintingPane;
	}

	@Override
	public void paintTree(Tree tree) {

		Arc arc = new Arc();

		// sets the size based on the size (S, M, L etc) of the tree
		double relativeSize = -1;

		switch (tree.getSize()) {
		case S:
			arc.setFill(Color.LAWNGREEN);
			relativeSize = 0.5;
			break;
		case M:
			arc.setFill(Color.FORESTGREEN);
			relativeSize = 0.6;
			break;
		case L:
			arc.setFill(Color.GREEN);
			relativeSize = 0.7;
			break;
		case XL:
			arc.setFill(Color.DARKGREEN);
			relativeSize = 0.8;
			break;
		case XXL:
			arc.setFill(Color.rgb(31,79,81));
			relativeSize = 1;
			break;
		default:
			break;

		}
		
		double radius = relativeSize * 10 * (tree.getRelY() / 10) - 10;
		
		arc.setRadiusX(radius);
		arc.setRadiusY(radius * 2);
		
		arc.setLength(50);
		
		arc.setStartAngle(245);

		arc.setCenterX(tree.getRelX() + (0 + new Random().nextInt(650 - 0 + 1)));

		arc.setCenterY((-10 + new Random().nextInt(100 - -10 + 1)));

		arc.setStroke(Color.BLACK);
		
		arc.setType(ArcType.ROUND);
		
		Rectangle trunk = new Rectangle(arc.getCenterX() - 6, arc.getCenterY() + radius * 1.5, radius / 4, radius);
		trunk.setStroke(Color.BLACK);
		trunk.setFill(Color.SADDLEBROWN);

		paintingPane.getChildren().addAll(trunk, arc);

	}

}

package view;

import controller.Controller;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import model.Tree;

public class PineTreePainter extends TreePainter {


	public PineTreePainter(PaintingPane paintingPane, Controller controller) {
		super(paintingPane, controller);
	}

	@Override
	public void paintTree(Tree tree) {

		Arc arc = new Arc();
		arc.setFill(decideColor(tree));
		
		
		// sets the size based on the size (S, M, L etc) of the tree
		double relativeSize = calculateRelativeSize(tree);
		
		// set the radius based on the relative size and the relative Y of the tree
		double radius = relativeSize * 10 * (tree.getRelY() / 10) - 10;
		arc.setRadiusX(radius);
		arc.setRadiusY(radius * 2);
		
		// calculates the centerX value of the crown using the relX and the radius.
		double arcX = 8 * tree.getRelX() + radius;

		// calculates the centerY value of the crown using the relX.
		double arcY = (tree.getRelY() - 50) * 4;
		
		arc.setLength(50);
		arc.setStartAngle(245);
		arc.setCenterX(arcX);
		arc.setCenterY(arcY);
		arc.setStroke(Color.BLACK);
		arc.setType(ArcType.ROUND);
		
		// Creates the trunk and uses the crown's values to make sure it aligns properly.
		Rectangle trunk = new Rectangle(arc.getCenterX() - 6, arc.getCenterY() + radius * 1.5, radius / 4, radius);
		trunk.setStroke(Color.BLACK);
		trunk.setFill(Color.SADDLEBROWN);
		
		// if the tree is out of view because the tree  underneath the window, it's moved up.
		while ((arcY + radius * 2 + trunk.getHeight()) > 300) {
			arcY--;
			arc.setCenterY(arcY);
			trunk.setY(arc.getCenterY() + radius * 1.5);
		}

		paintingPane.getChildren().addAll(trunk, arc);

	}

}

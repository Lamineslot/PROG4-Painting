package view;

import controller.Controller;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Tree;

public class LeafTreePainter extends TreePainter {

	public LeafTreePainter(PaintingPane paintingPane, Controller controller) {
		super(paintingPane, controller);
	}

	@Override
	public void paintTree(Tree tree) {
		Circle circle = new Circle();
		circle.setFill(decideColor(tree));

		// calculates the size based on the size (S, M, L etc) of the tree
		double relativeSize = calculateRelativeSize(tree);
		
		//calculates the radius based on the relative size of the tree and the relY
		double circleRadius = relativeSize * 5 * (tree.getRelY() / 10) - 10;
		
		// calculates the centerX value of the crown using the relX and the radius.
		double circleX = 8 * tree.getRelX() + circleRadius;

		// calculates the centerY value of the crown using the relX.
		double circleY = (tree.getRelY() - 50) * 5;

		circle.setRadius(circleRadius);
		circle.setCenterX(circleX);
		circle.setCenterY(circleY);
		circle.setStroke(Color.BLACK);
		circle.setRadius(circleRadius);

		// Creates the trunk and uses the crown's values to make sure it aligns properly.
		Rectangle trunk = new Rectangle(circle.getCenterX() - circleRadius / 4, circle.getCenterY() + circleRadius - 2,
				circleRadius / 2, circleRadius);
		trunk.setStroke(Color.BLACK);
		trunk.setFill(Color.SADDLEBROWN);

		// if the tree is out of view because the tree  underneath the window, it's moved up.
		while ((circleY + circleRadius * 2 + trunk.getHeight()) > 300) {
			circleY--;
			circle.setCenterY(circleY);
			trunk.setY(circle.getCenterY() + circleRadius - 2);
		}

		paintingPane.getChildren().addAll(trunk, circle);

	}

}

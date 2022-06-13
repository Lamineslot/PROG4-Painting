package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
			circle.setFill(Color.YELLOWGREEN);
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

		double centerX = 8 * tree.getRelX() + radius;
		circle.setCenterX(centerX);
		        
		double tempRelY = tree.getRelY() - 50;
		double centerY = tempRelY * 6;
		        
		Rectangle trunk = new Rectangle(circle.getCenterX() - radius/4, circle.getCenterY() + radius - 2, radius/2, radius);

		double trunkY = trunk.getY();
		double trunkHeight = trunk.getHeight();

		while ((trunkY + trunkHeight) > 300) {
		    centerY--;
		    trunkY--;
		    trunkHeight = trunkY + trunkHeight;
		    System.out.println("In loop, trunkY + trunkHeight: " + trunkY + trunkHeight + "\nCenterY: " + centerY);
		}
		        
		circle.setStroke(Color.BLACK);
		circle.setCenterY(centerY);
		trunk = new Rectangle(circle.getCenterX() - radius/4, circle.getCenterY() + radius - 2, radius/2, radius);
		
		trunk.setStroke(Color.BLACK);
		trunk.setFill(Color.SADDLEBROWN);

		paintingPane.getChildren().addAll(trunk, circle);

	}

}

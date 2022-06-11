package view;

import model.Tree;

public abstract class TreePainter {
	protected PaintingPane paintingPane;
	
	
	public TreePainter(PaintingPane paintingPane) {
		this.paintingPane = paintingPane;
	}
	
	abstract public void paintTree(Tree tree);

}

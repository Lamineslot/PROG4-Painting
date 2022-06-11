package view;

import model.Tree;

public abstract class TreePainter {
	protected PaintingPane paintingPane;

	protected TreePainter(PaintingPane paintingPane) {
		this.paintingPane = paintingPane;
	}

	public abstract void paintTree(Tree tree);

}

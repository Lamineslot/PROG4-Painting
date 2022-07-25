package model;

public class Tree implements Comparable<Tree> {
	private TreeSize size;
	private TreeType type;
	private double relX;
	private double relY;

	public Tree(TreeSize size, TreeType type, double relX, double relY) {
		this.size = size;
		this.type = type;
		this.relX = relX;
		this.relY = relY;
	}

	public TreeSize getSize() {
		return size;
	}

	public void setSize(TreeSize size) {
		this.size = size;
	}

	public TreeType getType() {
		return type;
	}

	public void setType(TreeType type) {
		this.type = type;
	}

	public double getRelX() {
		return relX;
	}

	public void setRelX(double relX) {
		this.relX = relX;
	}

	public double getRelY() {
		return relY;
	}

	public void setRelY(double relY) {
		this.relY = relY;
	}

	/**
	 * Used to move each tree a bit when the film is playing. Adds a value to the
	 * relX. If the tree is out of the window, it respawns so that it's shown again.
	 */
	public void move() {
		relX += 0.009 * relY;
		if (relX > 120) {
			relX = -20;
		}
	}

	/**
	 * Used to be able to call the Collections.Sort method on the ArrayList of
	 * trees, to ensure that trees with a low relY are drawn first.
	 */
	@Override
	public int compareTo(Tree tree) {
		int compareRelY = (int) tree.getRelY();
		return (int) (this.relY - compareRelY);
	}

}

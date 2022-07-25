package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class World {
	private ArrayList<Tree> trees;

	public World() {
		trees = new ArrayList<Tree>();
	}

	/**
	 * Creates a tree object using randomization, adds it to the list of trees and
	 * sorts the collection.
	 * 
	 * @param type Either {@linkplain TreeType#LEAF} or {@linkplain TreeType#PINE}
	 * @return tree A {@linkplain Tree} object that has a randomized size, relX and
	 *         relY.
	 */
	public Tree addTree(TreeType type) {
		Random random = new Random();
		if (type == TreeType.LEAF) {
			Tree tree = new Tree(TreeSize.values()[random.nextInt(TreeSize.values().length)], TreeType.LEAF,
					0 + random.nextInt(100 - 0 + 1), 50 + random.nextInt(100 - 50 + 1));
			trees.add(tree);
			Collections.sort(trees);
			return tree;
		} else if (type == TreeType.PINE) {
			Tree tree = new Tree(TreeSize.values()[random.nextInt(TreeSize.values().length)], TreeType.PINE,
					0 + random.nextInt(100 - 0 + 1), 50 + random.nextInt(100 - 50 + 1));
			trees.add(tree);
			Collections.sort(trees);
			return tree;
		} else {
			return null;
		}
	}

	/**
	 * Adds a pre-made tree to the list of trees. Used for trees that were made
	 * using file loading.
	 * 
	 * @param tree A pre-made tree
	 */
	public void addExistingTree(Tree tree) {
		trees.add(tree);
	}

	/**
	 * Calls the move method on each tree in the ArrayList.
	 */
	public void moveTrees() {
		for (Tree tree : trees) {
			tree.move();
		}
	}
	
	/** 
	 * Removes a tree object from the ArrayList.
	 * @param tree Tree object that must be removed.
	 */
	public void removeTree(Tree tree) {
		trees.remove(tree);
	}

	public ArrayList<Tree> getAllTrees() {
		return trees;
	}

}

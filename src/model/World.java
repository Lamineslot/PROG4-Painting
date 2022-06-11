package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class World {
	private ArrayList<Tree> trees;

	public World() {
		trees = new ArrayList<Tree>();
	}

	public Tree addTree(String string) {
		Random random = new Random();
		if (string.equals("leaf")) {
			Tree tree = new Tree(TreeSize.values()[new Random().nextInt(TreeSize.values().length)], TreeType.LEAF,
					0 + random.nextInt(100 - 0 + 1), 50 + random.nextInt(100 - 50 + 1));
			trees.add(tree);
			Collections.sort(trees);
			return tree;
		} else if (string.equals("pine")) {
			Tree tree = new Tree(TreeSize.values()[new Random().nextInt(TreeSize.values().length)], TreeType.PINE,
					0 + random.nextInt(100 - 0 + 1), 50 + random.nextInt(100 - 50 + 1));
			trees.add(tree);
			Collections.sort(trees);
			return tree;
		} else {
			return null;
		}
	}
	
	public void addExistingTree(Tree tree) {
		trees.add(tree);
	}

	public void moveTrees() {
		for (Tree tree : trees) {
			tree.move();
		}
	}

	public ArrayList<Tree> getAllTrees() {
		return trees;
	}

}

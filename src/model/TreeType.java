package model;

public enum TreeType {

	PINE, LEAF;

	public static TreeType fromString(String string) {
		switch (string) {
		case "pine":
			return PINE;
		case "leaf":
			return LEAF;
		default:
			return null;
		}
	}

	public static String toString(TreeType treeType) {
		switch(treeType) {
		case PINE:
			return "pine";
		case LEAF:
			return "leaf";
		default:
			return null;
		}
			
	}

}

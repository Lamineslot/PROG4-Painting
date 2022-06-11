package model;

public enum TreeSize {

	S, M, L, XL, XXL;

	public static TreeSize fromString(String string) {
		switch (string) {
		case "S":
			return S;
		case "M":
			return M;
		case "L":
			return L;
		case "XL":
			return XL;
		case "XXL":
			return XXL;
		default:
			return XXL;
		}
	}
	
	public static String toString(TreeSize treeSize) {
		switch(treeSize) {
		case S:
			return "S";
		case M:
			return "M";
		case L:
			return "L";
		case XL:
			return "XL";
		case XXL:
			return "XXL";
		default:
			return "S";
		}
	}

}

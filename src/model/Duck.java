package model;

public class Duck {
	private double x;
	private double y;
	private boolean shown;
	
	
	public Duck() {
		x = 250;
		y = 130;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public boolean isShown() {
		return shown;
	}
	public void setShown(boolean shown) {
		this.shown = shown;
	}

}

package view;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class AirPane extends BorderPane {
	private DuckPlayer duckPlayer;
	private Image duck;

	public AirPane() {
		// initializing instance variables
		duck = new Image("/pics/duckshapes.png");
		duckPlayer = new DuckPlayer(duck, 11, Duration.millis(100));

		// setting size and background
		setMinSize(800, 300);
		setMaxSize(800, 300);
		setBackground(new Background(new BackgroundFill(Color.SKYBLUE, null, null)));

	}

	public DuckPlayer getDuckPlayer() {
		return duckPlayer;
	}

	/**
	 * Clears the airPane to ensure that there's no other object and adds a 
	 */
	public void addDuckToPane() {
		getChildren().clear();
		getChildren().add(duckPlayer);
	}

	/**
	 * Updates the location of the duck by setting the X and Y of the duck. Used to be able to move the duck when keys are pressed.
	 * @param x x-position which the duck should move to
	 * @param y y-position which the duck should move to
	 */
	public void updateLocation(double x, double y) {
		getChildren().clear();
		duckPlayer.setX(x);
		duckPlayer.setY(y);
		getChildren().add(duckPlayer);
	}

	/**
	 * Starts the animation of the duck. Loops until {@link #stopDuckAnimation()} is called.
	 */
	public void startDuckAnimation() {
		duckPlayer.playContinuously();
	}

	/**
	 * Stops the duck animation.
	 */
	public void stopDuckAnimation() {
		duckPlayer.stop();
	}

}

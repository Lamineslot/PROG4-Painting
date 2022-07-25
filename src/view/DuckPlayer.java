package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class DuckPlayer extends ImageView {
	private final Rectangle2D[] cellClips;
	private int numCells;
	private final Timeline timeline;
	private final IntegerProperty frameCounter = new SimpleIntegerProperty(0);

	public DuckPlayer(Image animationImage, int numCells, Duration frameTime) {
		this.numCells = numCells;

		double cellWidth = 170d;
		double cellHeight = 150d;

		cellClips = new Rectangle2D[numCells];

		cellClips[0] = new Rectangle2D(385, 150, cellWidth, cellHeight);
		cellClips[1] = new Rectangle2D(0, 5, cellWidth, cellHeight);
		cellClips[2] = new Rectangle2D(195, 5, cellWidth, cellHeight);
		cellClips[3] = new Rectangle2D(385, 5, cellWidth, cellHeight);
		cellClips[4] = new Rectangle2D(195, 5, cellWidth, cellHeight);
		cellClips[5] = new Rectangle2D(0, 5, cellWidth, cellHeight);
		cellClips[6] = new Rectangle2D(385, 150, cellWidth, cellHeight);
		cellClips[7] = new Rectangle2D(195, 150, cellWidth, cellHeight);
		cellClips[8] = new Rectangle2D(0, 150, cellWidth, cellHeight);
		cellClips[9] = new Rectangle2D(195, 150, cellWidth, cellHeight);
		cellClips[10] = new Rectangle2D(385, 150, cellWidth, cellHeight);

		// sets the right image
		setImage(animationImage);
		setViewport(cellClips[0]);

		// creates the timeLine and a new keyframe for the animation
		timeline = new Timeline(new KeyFrame(frameTime, event -> {
			frameCounter.set((frameCounter.get() + 1) % numCells);
			setViewport(cellClips[frameCounter.get()]);
		}));
	}

	/**
	 * Used for the duck animation. Continuously loops over an array of images.
	 */
	public void playContinuously() {
		frameCounter.set(0);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.stop();
		timeline.playFromStart();
	}

	/**
	 * Stops the duck animation
	 */
	public void stop() {
		frameCounter.set(0);
		setViewport(cellClips[frameCounter.get()]);
		timeline.stop();
	}
}

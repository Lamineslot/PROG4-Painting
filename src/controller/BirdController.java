package controller;

import javafx.concurrent.Task;
import javafx.scene.input.KeyCode;
import model.Duck;
import view.PaintingScene;

public class BirdController {
	private Task<Void> playBird;
	private PaintingScene paintingScene;
	private Duck duck;
	private SoundPlayer soundPlayer;

	public BirdController(PaintingScene paintingScene) {
		playBird = new Task<Void>() {
		
			@Override
			protected Void call() throws Exception {
				if (paintingScene.getPlayButton().isSelected()) {
					paintingScene.getAirPane().getDuckPlayer().playContinuously();
					Thread.sleep(100);
				} else {
					paintingScene.getAirPane().getDuckPlayer().stop();
				}
				return null;
			}

		};
		this.paintingScene = paintingScene;
		duck = new Duck();
		soundPlayer = new SoundPlayer();
		
		// sets all actions on certain key presses for the animation and moving of the duck
		paintingScene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.D && !duck.isShown() && paintingScene.getPlayButton().isSelected()) {
				duck = new Duck();
				paintingScene.getAirPane().addDuckToPane();
				paintingScene.getAirPane().updateLocation(duck.getX(), duck.getY());
				duck.setShown(true);
				Thread birdThread = new Thread(playBird);
				birdThread.setDaemon(true);
				birdThread.start();
				soundPlayer.playQuack();
			} else if (e.getCode() == KeyCode.D && duck.isShown()) {
				duck = new Duck();
				paintingScene.getAirPane().getChildren().clear();
				duck.setShown(false);
				soundPlayer.playQuack();
			} else if (e.getCode() == KeyCode.LEFT && paintingScene.getPlayButton().isSelected() && duck.isShown()) {
				duck.setX(duck.getX() - 5);
				paintingScene.getAirPane().updateLocation(duck.getX(), duck.getY());
			} else if (e.getCode() == KeyCode.RIGHT && paintingScene.getPlayButton().isSelected() && duck.isShown()) {
				duck.setX(duck.getX() + 5);
				paintingScene.getAirPane().updateLocation(duck.getX(), duck.getY());
			}
		});
		
		
		
	}
	
	public Task<Void> getPlayBirdTask() {
		return playBird;
	}

	public Duck getDuck() {
		return duck;
	}
	
	

}

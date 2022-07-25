package controller;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
	// instance variables
	private final String soundfile = "duck-quack.wav";
	private Clip clip;
	

	/**
	 * Plays the sound file (a quack).
	 */
	public void playQuack() {
		playSound(soundfile);
	}
	
	/**
	 * Stops the quack in case a situation arises where the clip infinitely loops. 
	 */
	public void stopQuack() {
		clip.stop();
	}
	

	/**
	 * Helper method for creating the clip that is used to play or stop the sound file (quack).
	 * @param soundFile URL of the file in the sounds folder of the Resources of this project.
	 * @return the clip that is supposed to be played.
	 */
	private Clip playSound(String soundFile) {
		 clip = null;
		try {
			URL sound = getClass().getResource("/sounds/" + soundFile);
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
		}
		return clip;
	}

}

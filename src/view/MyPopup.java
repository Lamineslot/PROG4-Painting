package view;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;

public class MyPopup extends Popup {
	private Label label;
	
	public MyPopup(String text) {
		label = new Label(text);
		label.setMinWidth(120);
        label.setMinHeight(80);
        label.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        label.setTextAlignment(TextAlignment.CENTER);
        getContent().add(label);
	}

}

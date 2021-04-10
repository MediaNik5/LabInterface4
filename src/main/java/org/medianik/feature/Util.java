package org.medianik.feature;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

import static javafx.scene.paint.Color.WHITE;

public class Util{
	public static final Paint BUTTON_COLOR = WHITE;

	public static JFXButton newButton(){
		return newButton("");
	}

	public static JFXButton newButton(String name){
		JFXButton button = new JFXButton(name);
		button.setButtonType(JFXButton.ButtonType.RAISED);
		button.setBackground(
				new Background(
						new BackgroundFill(
								BUTTON_COLOR,
								new CornerRadii(5),
								Insets.EMPTY)
				)
		);
		button.setDisableVisualFocus(true);
		return button;
	}
}

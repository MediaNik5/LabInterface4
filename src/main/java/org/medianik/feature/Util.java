package org.medianik.feature;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import static javafx.scene.paint.Color.WHITE;
import static org.medianik.feature.Feature.FONT_SIZE;

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
								Insets.EMPTY
						)
				)
		);
		button.setFont(Font.font(FONT_SIZE));
		button.setDisableVisualFocus(true);
		return button;
	}
}

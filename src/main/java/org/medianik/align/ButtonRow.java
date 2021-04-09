package org.medianik.align;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.medianik.feature.Util;

import static org.medianik.feature.Feature.HEIGHT_OF_ROW;

public class ButtonRow extends Row{

	private final JFXButton button;

	public ButtonRow(String text, EventHandler<? super MouseEvent> onClick, Pane pane){
		button = Util.newButton(text);
		button.setOnMouseClicked(onClick);
		button.setMaxHeight(HEIGHT_OF_ROW);
		button.setMinHeight(HEIGHT_OF_ROW);
		pane.getChildren().add(button);
	}

	@Override
	protected void setYOffset(double yOffset){
		button.setTranslateY(yOffset);
	}

	@Override
	protected double getHeightOfRow(){
		return HEIGHT_OF_ROW;
	}
}

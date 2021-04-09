package org.medianik.align;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import static org.medianik.feature.Feature.*;

public class PropertyRow extends Row{
	private final String text;
	private final String placeholder;
	private final TextField textField;
	private final Label label;

	public PropertyRow(String text, String placeholder, Pane pane){
		this.text = text;
		this.placeholder = placeholder;
		textField = initTextField(pane);
		label = initLabel(pane);
	}

	private Label initLabel(Pane pane){
		final Label label;
		label = new Label(text);
		pane.getChildren().add(label);
		pane.applyCss();
		pane.layout();
		label.setTranslateX(-label.getWidth()/2 - OFFSET);
		return label;
	}

	private TextField initTextField(Pane pane){
		final TextField textField;
		textField = new TextField();
		pane.getChildren().add(textField);
		textField.setMaxHeight(HEIGHT_OF_ROW);
		textField.setMinHeight(HEIGHT_OF_ROW);
		textField.setPromptText(placeholder);
		textField.setMaxWidth(FIELD_WIDTH);
		textField.setTranslateX(FIELD_WIDTH/2 + OFFSET);
		return textField;
	}

	@Override
	protected void setYOffset(double yOffset){
		textField.setTranslateY(yOffset);
		label.setTranslateY(yOffset);
	}

	@Override
	protected double getHeightOfRow(){
		return HEIGHT_OF_ROW;
	}

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(!(o instanceof Row)) return false;

		PropertyRow propertyRow = (PropertyRow) o;

		if(!text.equals(propertyRow.text)) return false;
		return placeholder.equals(propertyRow.placeholder);
	}

	@Override
	public int hashCode(){
		int result = text.hashCode();
		result = 31*result + placeholder.hashCode();
		return result;
	}

}

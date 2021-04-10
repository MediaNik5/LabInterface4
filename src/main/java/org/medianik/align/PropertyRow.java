package org.medianik.align;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import static org.medianik.feature.Feature.*;

public class PropertyRow extends NamedRow{
	private final String placeholder;
	private final TextField textField;

	public PropertyRow(String label, String placeholder, Pane pane){
		super(label, pane);
		this.placeholder = placeholder;
		textField = initTextField(pane);
	}

	private TextField initTextField(Pane pane){
		final TextField textField;
		textField = new TextField();
		pane.getChildren().add(textField);
		textField.setMaxHeight(HEIGHT_OF_ROW);
		textField.setMinHeight(HEIGHT_OF_ROW);
		textField.setPromptText(placeholder);
		textField.setMaxWidth(FIELD_WIDTH);
		textField.setTranslateX(FIELD_WIDTH/2. + OFFSET);
		return textField;
	}

	@Override
	protected void setYOffset(double yOffset){
		super.setYOffset(yOffset);
		textField.setTranslateY(yOffset);
	}

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(!(o instanceof Row)) return false;

		PropertyRow propertyRow = (PropertyRow) o;

		if(!super.equals(propertyRow)) return false;
		return placeholder.equals(propertyRow.placeholder);
	}

	@Override
	public int hashCode(){
		int result = super.hashCode();
		result = 31*result + placeholder.hashCode();
		return result;
	}

}

package org.medianik.align;

import com.jfoenix.controls.JFXColorPicker;
import javafx.scene.layout.Pane;

import static org.medianik.feature.Feature.FIELD_WIDTH;
import static org.medianik.feature.Feature.OFFSET;

@Deprecated
public class ColorPickerRow extends NamedRow{

	private final JFXColorPicker picker;

	public ColorPickerRow(String label, Pane pane){
		super(label, pane);
		picker = initPicker(pane);
	}

	private JFXColorPicker initPicker(Pane pane){
		var picker = new JFXColorPicker();
		picker.setMaxWidth(FIELD_WIDTH);
		picker.setMinWidth(FIELD_WIDTH);
		picker.setTranslateX(OFFSET + FIELD_WIDTH/2.);
		pane.getChildren().add(picker);
		return picker;
	}

	@Override
	protected void setYOffset(double yOffset){
		super.setYOffset(yOffset);
		picker.setTranslateY(yOffset);
	}
}

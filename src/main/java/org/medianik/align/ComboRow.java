package org.medianik.align;

import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import static org.medianik.feature.Feature.*;

public class ComboRow extends NamedRow{

	private final JFXComboBox<String> comboBox;


	public ComboRow(String label, Pane pane, String... contents){
		super(label, pane);
		comboBox = initComboBox(pane, contents);
	}

	private JFXComboBox<String> initComboBox(Pane pane, String[] contents){
		var comboBox = new JFXComboBox<String>();

		pane.getChildren().add(comboBox);
		pane.applyCss();
		pane.layout();

		comboBox.setMaxWidth(FIELD_WIDTH);
		comboBox.setMinWidth(FIELD_WIDTH);
		comboBox.setTranslateX(OFFSET + FIELD_WIDTH/2.);
		comboBox.getItems().addAll(contents);
		return comboBox;
	}

	@Override
	protected void setYOffset(double yOffset){
		super.setYOffset(yOffset);
		comboBox.setTranslateY(yOffset);
	}

	@Override
	protected double getHeightOfRow(){
		return HEIGHT_OF_ROW;
	}
}

package org.medianik.align;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import org.medianik.feature.Feature;

import static org.medianik.feature.Feature.HEIGHT_OF_ROW;
import static org.medianik.feature.Feature.OFFSET;

public class NamedRow extends Row{

	private final String text;
	private final Label label;

	public NamedRow(String label, Pane pane){
		text = label;
		this.label = initLabel(pane);
	}

	private Label initLabel(Pane pane){
		final Label label = new Label(text);
		label.setFont(Font.font(Feature.FONT_SIZE));
		pane.getChildren().add(label);
		pane.applyCss();
		pane.layout();
		label.setTranslateX(-label.getWidth()/2 - OFFSET);

		return label;
	}

	@Override
	protected void setYOffset(double yOffset){
		label.setTranslateY(yOffset);
	}

	@Override
	protected double getHeightOfRow(){
		return HEIGHT_OF_ROW;
	}

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(!(o instanceof NamedRow)) return false;

		NamedRow namedRow = (NamedRow) o;

		return text.equals(namedRow.text);
	}

	@Override
	public int hashCode(){
		return text.hashCode();
	}
}

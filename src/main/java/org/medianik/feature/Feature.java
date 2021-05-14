package org.medianik.feature;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.medianik.align.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class Feature{
	public final static double OFFSET = 15;
	public final static double HEIGHT_OF_ROW = 90;
	public static final double FIELD_WIDTH = 400;
	public static final boolean RESIZABLE = false;
	public static final int FONT_SIZE = 40;
	protected static final int WIDTH = 1000;
	protected static final int HEIGHT = 600;

	private final Button button;
	private final String name;
	private final Pane pane;
	private final double width;
	private final double height;
	private final List<Row> properties = new ArrayList<>();
	private final FeatureRow row;
	private Stage window;

	protected Feature(String name, double width, double height, Consumer<Button> nodeAdder){
		this.name = name;
		this.width = width;
		this.height = height;
		button = initButton(nodeAdder);
		pane = initPane();
		initWindow();
		row = new FeatureRow();
	}

	protected abstract void initWindow();

	private Pane initPane(){
		var pane = new StackPane();
		var scene = new Scene(pane, width, height);
		window = new Stage();
		window.setResizable(RESIZABLE);
		window.setTitle(name);
		window.setScene(scene);
		pane.setOnMouseClicked(t -> pane.requestFocus());
		return pane;
	}

	private Button initButton(Consumer<Button> buttonAdder){
		Button button = Util.newButton(name);
		button.setOnAction(this::onClick);
		buttonAdder.accept(button);
		return button;
	}

	private Pane getPane(){
		return pane;
	}

	protected void show(){
		window.show();
		updateProperties();
	}

	protected void close(){
		window.close();
	}

	public void onClick(ActionEvent event){
		show();
	}

	public void addProperty(String label, String placeholder){
		properties.add(new PropertyRow(label, placeholder, pane));
	}

	public void addButton(String text, EventHandler<? super MouseEvent> onClick){
		properties.add(new ButtonRow(text, onClick, pane));
	}

	public void addComboBox(String label, String... contents){
		properties.add(new ComboRow(label, pane, contents));
	}

	@Deprecated
	public void addColorPicker(String label){
		properties.add(new ColorPickerRow(label, pane));
	}

	protected final void updateProperties(){
		for(int i = 0; i < properties.size(); i++)
			properties.get(i).update(i, properties.size());
	}

	protected void addNode(Node node){
		getPane().getChildren().add(node);
		getPane().requestFocus();
	}

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(!(o instanceof Feature)) return false;

		Feature feature = (Feature) o;

		if(Double.compare(feature.width, width) != 0) return false;
		if(Double.compare(feature.height, height) != 0) return false;
		if(!name.equals(feature.name)) return false;
		return Objects.equals(window, feature.window);
	}

	@Override
	public int hashCode(){
		int result;
		long temp;
		result = name.hashCode();
		temp = Double.doubleToLongBits(width);
		result = 31*result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = 31*result + (int) (temp ^ (temp >>> 32));
		result = 31*result + (window != null ? window.hashCode() : 0);
		return result;
	}

	public FeatureRow toRow(){
		return row;
	}

	public class FeatureRow extends Row{
		private FeatureRow(){
		}

		public Feature toFeature(){
			return Feature.this;
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
}

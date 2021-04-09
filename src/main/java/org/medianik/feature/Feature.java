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
import org.medianik.align.ButtonRow;
import org.medianik.align.PropertyRow;
import org.medianik.align.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Feature{
	public final static double OFFSET = 5;
	public final static double HEIGHT_OF_ROW = 25;
	public static final double FIELD_WIDTH = 150;

	private final String name;
	private final Pane pane;
	private final double width;
	private final double height;
	private Stage window;
	private final List<Row> properties = new ArrayList<>();

	protected Feature(String name, double width, double height, Consumer<Button> nodeAdder){
		this.name = name;
		this.width = width;
		this.height = height;
		initButton(nodeAdder);
		pane = initPane();
		initWindow();
	}

	protected abstract void initWindow();

	private Pane initPane(){
		var pane = new StackPane();
		var scene = new Scene(pane, width, height);
		window = new Stage();
		window.setResizable(false);
		window.setTitle(name);
		window.setScene(scene);
		pane.setOnMouseClicked(t -> pane.requestFocus());
		return pane;
	}

	private void initButton(Consumer<Button> buttonAdder){
		Button button = Util.newButton("Add contact");
		button.setOnAction(this::onClick);
		buttonAdder.accept(button);
	}

	private Pane getPane(){
		return pane;
	}

	protected void show(){
		window.show();
	}
	protected void close(){
		window.close();
	}

	public void onClick(ActionEvent event){
		show();
	}


	public void addProperty(String label, String placeholder){
		properties.add(new PropertyRow(label, placeholder, pane));
		updateProperties();
	}

	public void addButton(String text, EventHandler<? super MouseEvent> onClick){
		properties.add(new ButtonRow(text, onClick, pane));
		updateProperties();
	}

	protected final void updateProperties(){
		for(int i = 0; i < properties.size(); i++)
			properties.get(i).update(i, properties.size());
	}

	protected void addNode(Node node){
		getPane().getChildren().add(node);
		getPane().requestFocus();
	}
}

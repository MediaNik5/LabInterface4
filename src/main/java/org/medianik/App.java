package org.medianik;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.medianik.align.Row;
import org.medianik.feature.CategoryAdding;
import org.medianik.feature.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * JavaFX App
 */
public class App extends Application{

	private final Pane pane;
	private final List<Feature.FeatureRow> features;

	public App(){
		pane = new StackPane();
		features = new ArrayList<>();
	}

	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage stage){
		var scene = new Scene(pane, 640, 480);
		initFeatures();
		updateFeatures();
		stage.setScene(scene);
		stage.show();
	}

	private void initFeatures(){
		var v = new CategoryAdding(getAdder());
		features.add(v.toRow());
		var v1 = new CategoryAdding(getAdder());
		features.add(v1.toRow());
	}

	private Consumer<Button> getAdder(){
		return pane.getChildren()::add;
	}

	private void updateFeatures(){
		for(int i = 0; i < features.size(); i++)
			features.get(i).update(i, features.size());
	}

}
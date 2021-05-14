package org.medianik;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.medianik.feature.AddContact;
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

	public ImageView getImage(String name){
		var stream = this.getClass().getResourceAsStream(name);
		var image = new Image(stream);
		return new ImageView(image);
	}

	public App(){
		pane = new StackPane(getImage("/logo.png"));
		features = new ArrayList<>();
	}

	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage stage){
		var scene = new Scene(pane, 900, 900);
		initFeatures();
		updateFeatures();
		stage.setScene(scene);
		stage.show();
	}

	private void initFeatures(){
		var v = new CategoryAdding(getAdder());
		features.add(v.toRow());
		var v1 = new AddContact(getAdder());
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
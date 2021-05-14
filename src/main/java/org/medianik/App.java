package org.medianik;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.medianik.align.Row;
import org.medianik.feature.AddAdmin;
import org.medianik.feature.AddContact;
import org.medianik.feature.AddCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * JavaFX App
 */
public class App extends Application{

	private final Pane pane;
	private final List<Row> features;

	public ImageView getImage(String name){
		var stream = this.getClass().getResourceAsStream(name);
		var image = new Image(stream);
		return new ImageView(image);
	}

	public App(){
		pane = new StackPane(/*getImage("/logo.png")*/);
		features = new ArrayList<>();
	}

	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage stage){
		var scene = new Scene(pane, 700, 700);
		initFeatures();
		updateFeatures();
		stage.setScene(scene);
		stage.show();
	}

	private void initFeatures(){
		var featureAddCategory = new AddCategory(getAdder());
		features.add(featureAddCategory.toRow());
		var featureAddContact = new AddContact(getAdder());
		features.add(featureAddContact.toRow());
		var featureAddAdmin = new AddAdmin(getAdder());
		features.add(featureAddAdmin.toRow());
	}

	private Consumer<Button> getAdder(){
		return pane.getChildren()::add;
	}

	private void updateFeatures(){
		for(int i = 0; i < features.size(); i++)
			features.get(i).update(i, features.size());
	}

}
package org.medianik;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.medianik.feature.CategoryAdding;

/**
 * JavaFX App
 */
public class App extends Application {

    private final Pane pane;

    public App(){
        pane = new StackPane();
    }

    @Override
    public void start(Stage stage) {
        var scene = new Scene(pane, 640, 480);
        new CategoryAdding("Privet", pane.getChildren()::add);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
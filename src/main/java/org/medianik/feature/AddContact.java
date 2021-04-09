package org.medianik.feature;

import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.Button;

import java.util.function.Consumer;

public class AddContact extends Feature{

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;

	public AddContact(String name, Consumer<Button> nodeAdder){
		super(name, WIDTH, HEIGHT, nodeAdder);
	}

	@Override
	protected void initWindow(){
		addProperty("Number", "+79876543210");
		addProperty("Name", "John");
		addProperty("Last name", "Smith");
//		addProperty("smth", "smth");
		JFXComboBox<String> box = new JFXComboBox<>();
		addNode(box);
		box.getItems().add()
		addButton("Done", (e) -> close());
	}

}

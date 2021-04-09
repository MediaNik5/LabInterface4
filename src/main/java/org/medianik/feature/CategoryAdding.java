package org.medianik.feature;

import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.Button;

import java.util.function.Consumer;

public class CategoryAdding extends Feature{

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;

	public CategoryAdding(String name, Consumer<Button> nodeAdder){
		super(name, WIDTH, HEIGHT, nodeAdder);
	}

	@Override
	protected void initWindow(){
		addProperty("Category", "Name here");
//		addProperty("smth", "smth");
		addComboBox("Choose", "Red", "Green", "Here");
		addButton("Done", (e) -> close());
	}

}

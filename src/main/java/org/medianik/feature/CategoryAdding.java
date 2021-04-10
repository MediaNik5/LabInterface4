package org.medianik.feature;

import javafx.scene.control.Button;

import java.util.function.Consumer;

public class CategoryAdding extends Feature{

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	private static final String name = "Add category";

	public CategoryAdding(Consumer<Button> nodeAdder){
		super(name, WIDTH, HEIGHT, nodeAdder);
	}

	@Override
	protected void initWindow(){
		addProperty("Category", "Name here");
		addComboBox("Choose", "Red", "Green", "Blue");
		addButton("Done", (e) -> close());
		updateProperties();
	}

}

package org.medianik.feature;

import javafx.scene.control.Button;

import java.util.function.Consumer;

public class CategoryAdding extends Feature{

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

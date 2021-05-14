package org.medianik.feature;

import javafx.scene.control.Button;

import java.util.function.Consumer;

public class AddContact extends Feature{

	public AddContact(Consumer<Button> nodeAdder){
		super("Add contact", WIDTH, HEIGHT, nodeAdder);
	}

	@Override
	protected void initWindow(){
		addProperty("Add first name", "");
		addProperty("Add last name", "");
		addProperty("Add phone number", "8**********");
		addButton("Confirm", (event -> close()));

	}
}

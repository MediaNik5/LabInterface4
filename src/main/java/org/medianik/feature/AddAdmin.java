package org.medianik.feature;

import javafx.scene.control.Button;

import java.util.function.Consumer;

public class AddAdmin extends Feature{
    public AddAdmin(Consumer<Button> adder) {
        super("Add Admin", WIDTH, HEIGHT, adder);
    }

    @Override
    protected void initWindow() {
        addProperty("Enter FIO", "FIO here");
        addProperty("Enter phone", "+7-(***)-***-**-**");
        addButton("Confirm", (e) -> close());
    }
}

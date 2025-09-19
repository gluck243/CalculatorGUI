package com.ivanov.antony.buttons;

import com.ivanov.antony.tokenizer.Token;
import javafx.scene.control.TextField;

import java.util.function.Supplier;

public class InputButton extends AbstractButton {

    public InputButton(String text, Supplier<Token[]> tokenize, TextField output) {
        super(text, event -> {
            Token[] tokens = tokenize.get();
            for (Token token : tokens) {
                output.setText(output.getText() + token.getValue());
            }
        });
    }

}

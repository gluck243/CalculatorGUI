package com.ivanov.antony.buttons;

import com.ivanov.antony.tokenizer.Tokenizer;

import javax.swing.*;

public class ClearButton extends AbstractButton {

    public ClearButton(Tokenizer tokenizer, JTextField output) {
        super("Clear", event -> {
            output.setText("");
            tokenizer.clearTokens();
        });
    }
}
package com.ivanov.antony.buttons;

import com.ivanov.antony.tokenizer.Tokenizer;

import javax.swing.*;

public class DeleteButton extends ButtonWithImage {

    public DeleteButton(String iconPath, Tokenizer tokenizer, JTextField output) {
        super(iconPath, event -> {
            output.setText(output.getText().substring(0, output.getText().length() - 1));
            tokenizer.deleteLastToken();
        });
    }
}
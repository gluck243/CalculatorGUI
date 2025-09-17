package com.ivanov.antony.buttons;

import com.ivanov.antony.evaluator.Evaluator;
import com.ivanov.antony.parser.Node;
import com.ivanov.antony.parser.Parser;
import com.ivanov.antony.tokenizer.Tokenizer;

import javax.swing.*;
import java.util.List;

public class EqualsButton extends AbstractButton {

    public EqualsButton(Tokenizer tokenizer, Parser parser, Evaluator evaluator, JTextField output) {
        super("=", event -> {
            try {
                // First, checking for mismatched parentheses before tokenizing.
                if (tokenizer.isOpenedBracket()) {
                    output.setText("Error: Mismatched brackets");
                } else {
                    // Then, proceeding with tokenizing and calculation.
                    List<Node> nodes = parser.parse(tokenizer.getTokens());
                    try {
                        double result = evaluator.evaluate(nodes);
                        output.setText(String.valueOf(result));
                    } catch (ArithmeticException ex) {
                        output.setText("Error:" + ex.getMessage());
                    }
                }

            } catch (Exception ex) {
                output.setText("An unknown error occurred");
            } finally {
                tokenizer.clearTokens();
            }
        });
    }
}
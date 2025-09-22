package com.ivanov.antony;

import com.ivanov.antony.buttons.AbstractButton;
import com.ivanov.antony.buttons.InputButton;
import com.ivanov.antony.evaluator.Evaluator;
import com.ivanov.antony.evaluator.ReversePolishNotationEvaluator;
import com.ivanov.antony.parser.Node;
import com.ivanov.antony.parser.Parser;
import com.ivanov.antony.parser.ReversePolishNotationParser;
import com.ivanov.antony.tokenizer.Token;
import com.ivanov.antony.tokenizer.Tokenizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.print.DocFlavor;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import static com.ivanov.antony.tokenizer.MathOperationToken.*;

public class Controller {

    private final Tokenizer tokenizer =  new Tokenizer();
    private final Parser parser = new ReversePolishNotationParser();
    private final Evaluator evaluator = new ReversePolishNotationEvaluator();

    @FXML
    private TextField textField;

    @FXML
    public void initialize() {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            textField.positionCaret(newValue.length());
        });
    }

    public void onNumberButtonPressed(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        Supplier<Token[]> tokenize = () -> tokenizer.addDigit(Integer.parseInt(clickedButton.getText()));
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
        // I need the text to appear in the textfield
        // I need the number or operation to be tokenized
    }

    public void onPlusButtonPressed(ActionEvent event) {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(PLUS);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }public void onMinusButtonPressed(ActionEvent event) {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(MINIS);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }public void onMultiplicationButtonPressed(ActionEvent event) {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(MULTIPLY);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }public void onDivButtonPressed(ActionEvent event) {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(DIVIDE);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }public void onModButtonPressed(ActionEvent event) {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(MOD);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void OnBracketsButtonPressed(ActionEvent event) {
        Supplier<Token[]> tokenize = tokenizer::addBracket;
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onBracketOpen(ActionEvent event) {}
    public void onBracketClose(ActionEvent event) {}

    public void onDeleteButtonPressed() {
        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
        tokenizer.deleteLastToken();
    }

    public void onClearButtonPressed(ActionEvent event) {
//        Button clickedButton = (Button) event.getSource();
        textField.setText("");
        tokenizer.clearTokens();
    }

    @FXML
    private VBox normalModePane;
    @FXML
    private VBox shiftModePane;

    private boolean isShiftMode = false;

    @FXML
    private void onShiftButtonPressed(ActionEvent event) {
        isShiftMode = !isShiftMode; // Flip the state
        updateVisibility();
    }

    private void updateVisibility() {
        if (isShiftMode) {
            // Shift mode is active: show the split-button pane
            normalModePane.setVisible(false);
            shiftModePane.setVisible(true);
        } else {
            // Normal mode is active: show the default pane
            normalModePane.setVisible(true);
            shiftModePane.setVisible(false);
        }
    }

    public void inEqualsButtonPressed() {
        try {
            // First, checking for mismatched parentheses before tokenizing.
            if (tokenizer.isOpenedBracket()) {
                textField.setText("Error: Mismatched brackets");
            } else {
                // Then, proceeding with tokenizing and calculation.
                List<Node> nodes = parser.parse(tokenizer.getTokens());
                try {
                    if (evaluator.evaluate(nodes) % 1 == 0) {
                        textField.setText(String.valueOf((int) evaluator.evaluate(nodes)));
                    } else
                        textField.setText(String.valueOf(evaluator.evaluate(nodes)));
                } catch (ArithmeticException ex) {
                    textField.setText("Error:" + ex.getMessage());
                }
            }

        } catch (Exception ex) {
            textField.setText("An unknown error occurred");
        } finally {
            tokenizer.clearTokens();
        }
    }
}

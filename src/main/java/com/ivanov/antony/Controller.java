package com.ivanov.antony;

import com.ivanov.antony.evaluator.Evaluator;
import com.ivanov.antony.evaluator.ReversePolishNotationEvaluator;
import com.ivanov.antony.parser.Node;
import com.ivanov.antony.parser.Parser;
import com.ivanov.antony.parser.ReversePolishNotationParser;
import com.ivanov.antony.tokenizer.Token;
import com.ivanov.antony.tokenizer.Tokenizer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.util.List;
import java.util.function.Supplier;

import static com.ivanov.antony.tokenizer.MathOperationToken.*;

public class Controller {

    private final Tokenizer tokenizer =  new Tokenizer();
    private final Parser parser = new ReversePolishNotationParser();
    private final Evaluator evaluator = new ReversePolishNotationEvaluator();

    @FXML
    private TextField textField;
    @FXML
    private VBox normalModePane;
    @FXML
    private VBox shiftModePane;

    private boolean isShiftMode = false;

    @FXML
    public void initialize() {
        textField.textProperty().addListener((obs, oldText, newText) -> {
            Platform.runLater(() -> textField.end());
        });
    }

    public void onNumberButtonPressed(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        Supplier<Token[]> tokenize = () -> tokenizer.addDigit(Integer.parseInt(clickedButton.getText()));
        if (tokenizer.isEmpty()) {
            Token[] tokens = tokenize.get();
            for (Token token : tokens) {
                textField.setText("" + token.getValue());
            }
        }
        else {
            Token[] tokens = tokenize.get();
            for (Token token : tokens) {
                textField.setText(textField.getText() + token.getValue());
            }
        }
    }

    public void onDotButtonPressed() {
        Supplier<Token[]> tokenize = tokenizer::addDot;
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onPlusButtonPressed() {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(PLUS);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onMinusButtonPressed() {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(MINIS);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onMultiplicationButtonPressed() {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(MULTIPLY);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onDivButtonPressed() {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(DIVIDE);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onModButtonPressed() {
        Supplier<Token[]> tokenize = () -> tokenizer.addMathOperation(MOD);
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void OnBracketsButtonPressed() {
        Supplier<Token[]> tokenize = tokenizer::addBracket;
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onBracketOpen() {
        Supplier<Token[]> tokenize = tokenizer::addOpenedBracket;
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onBracketClose() {
        Supplier<Token[]> tokenize = tokenizer::addClosedBracket;
        Token[] tokens = tokenize.get();
        for (Token token : tokens) {
            textField.setText(textField.getText() + token.getValue());
        }
    }

    public void onDeleteButtonPressed() {
        if (!textField.getText().isEmpty()) {
            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            tokenizer.deleteLastToken();
        }
    }

    public void onClearButtonPressed() {
        textField.setText("");
        tokenizer.clearTokens();
    }

    @FXML
    private void onShiftButtonPressed() {
        isShiftMode = !isShiftMode; // Flip the state
        updateVisibility();
    }

    private void updateVisibility() {
        normalModePane.setVisible(!isShiftMode);
        shiftModePane.setVisible(isShiftMode);
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

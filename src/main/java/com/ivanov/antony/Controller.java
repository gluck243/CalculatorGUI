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

    public void displayUpdate(Supplier<Token[]> tokenize, boolean append) {
        Token[] tokens = tokenize.get();
        StringBuilder textToDisplay = new StringBuilder();
        if (append) {
            textToDisplay.append(textField.getText());
        }
        for (Token token : tokens) {
            textToDisplay.append(token.getValue());
        }
        textField.setText(textToDisplay.toString());
    }

    public void onNumberButtonPressed(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        displayUpdate(() -> tokenizer.addDigit(Integer.parseInt(clickedButton.getText())), !tokenizer.isEmpty());
    }

    public void onDotButtonPressed() {
        displayUpdate(tokenizer::addDot, true);
    }

    public void onPlusButtonPressed() {
        displayUpdate(() -> tokenizer.addMathOperation(PLUS), true);
    }

    public void onMinusButtonPressed() {
        displayUpdate(() -> tokenizer.addMathOperation(MINIS), !tokenizer.isEmpty());
    }

    public void onMultiplicationButtonPressed() {
        displayUpdate(() -> tokenizer.addMathOperation(MULTIPLY), true);
    }

    public void onDivButtonPressed() {
        displayUpdate(() -> tokenizer.addMathOperation(DIVIDE), true);
    }

    public void onModButtonPressed() {
        displayUpdate(() -> tokenizer.addMathOperation(MOD), true);
    }

    public void OnBracketsButtonPressed() {
        displayUpdate(tokenizer::addBracket, !tokenizer.isEmpty());
    }

    public void onBracketOpen() {
        displayUpdate(tokenizer::addOpenedBracket, !tokenizer.isEmpty());
    }

    public void onBracketClose() {
        displayUpdate(tokenizer::addClosedBracket, true);
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
            if (tokenizer.isOpenedBracket()) {
                textField.setText("Error: Mismatched brackets");
            } else {
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
            ex.printStackTrace();
            textField.setText("An unknown error occurred");
        } finally {
            tokenizer.clearTokens();
        }
    }
}

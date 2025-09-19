package com.ivanov.antony;

import com.ivanov.antony.buttons.AbstractButton;
import com.ivanov.antony.buttons.InputButton;
import com.ivanov.antony.evaluator.Evaluator;
import com.ivanov.antony.parser.Parser;
import com.ivanov.antony.tokenizer.Token;
import com.ivanov.antony.tokenizer.Tokenizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionListener;
import java.util.function.Supplier;

import static com.ivanov.antony.tokenizer.MathOperationToken.*;

public class Controller {

    private final Tokenizer tokenizer =  new Tokenizer();
    private Parser parser;
    private Evaluator evaluator;

    @FXML
    private TextField textField;

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

    public void OnBracketsButtonPressed(ActionEvent event) {}

    public void onDeleteButtonPressed() {
        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
        tokenizer.deleteLastToken();
    }

    public void onClearButtonPressed(ActionEvent event) {
//        Button clickedButton = (Button) event.getSource();
        textField.setText("");
        tokenizer.clearTokens();
    }

    public void inEqualsButtonPressed() {}
}

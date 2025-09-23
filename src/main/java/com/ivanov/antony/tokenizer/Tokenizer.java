package com.ivanov.antony.tokenizer;

import lombok.Getter;

import java.util.Deque;
import java.util.LinkedList;

import static com.ivanov.antony.tokenizer.BracketToken.CLOSED_BRACKET;
import static com.ivanov.antony.tokenizer.BracketToken.OPENED_BRACKET;
import static com.ivanov.antony.tokenizer.MathOperationToken.MULTIPLY;
import static com.ivanov.antony.tokenizer.SpecialTokens.DOT;
import static com.ivanov.antony.tokenizer.SpecialTokens.UNARY_MINUS;

public class Tokenizer {

    @Getter
    private final Deque<Token> tokens;
    private int unclosedBrackets = 0;

    public Tokenizer() {
        this.tokens = new LinkedList<>();
    }

    public void addTokens(Token... tokens) {
        for (Token token : tokens) {
            this.tokens.addLast(token);
        }
    }

    public Token[] addDigit(int digit) {
        Token[] tokens = new Token[]{new DigitToken(digit)};
        addTokens(tokens);
        return tokens;
    }

    public Token[] addMathOperation(MathOperationToken operation) {
        Token[] tokens = new Token[0];
        if (isUnary()) {
            tokens = new Token[]{UNARY_MINUS};
        } else if (canBeAdded()) {
            tokens = new Token[]{operation};
        }
        addTokens(tokens);
        return tokens;
    }

    public Token[] addBracket() {
        Token[] tokens;
        Token lastToken = null;
        if (!isEmpty()) {
            lastToken = getLastToken();
        }

        if (isOpenedBracket() && (lastToken instanceof DigitToken || lastToken == CLOSED_BRACKET)) {
            tokens = new Token[]{CLOSED_BRACKET};
            addTokens(tokens);
            closeBracket();
            return tokens;
        }

        if (lastToken instanceof DigitToken || lastToken == CLOSED_BRACKET) {
            tokens = new Token[]{MULTIPLY, OPENED_BRACKET};
        } else {
            tokens = new Token[]{OPENED_BRACKET};
        }
        addTokens(tokens);
        openBracket();
        return tokens;
    }

    public Token[] addOpenedBracket() {
        Token[] tokens;
        Token lastToken = null;
        if (!isEmpty()) {
            lastToken = getLastToken();
        }
        if (lastToken instanceof DigitToken || lastToken == CLOSED_BRACKET) {
            tokens = new Token[]{MULTIPLY, OPENED_BRACKET};
        } else {
            tokens = new Token[]{OPENED_BRACKET};
        }
        addTokens(tokens);
        openBracket();
        return tokens;
    }

    public Token[] addClosedBracket() {
        Token[] tokens = new Token[0];
        if (isOpenedBracket() && !lastTokenIsOperation() && getLastToken() != OPENED_BRACKET) {
            tokens = new Token[]{CLOSED_BRACKET};
            addTokens(tokens);
            closeBracket();
        }
        return tokens;
    }

    public Token[] addDot() {
        Token[] tokens;
        if (isEmpty()) {
            tokens = new Token[]{new DigitToken(0), DOT};
        } else {
            tokens = new Token[]{DOT};
        }
        addTokens(tokens);
        return tokens;
    }

    public Token getLastToken() {
        return tokens.getLast();
    }

    public boolean isEmpty() {
        return tokens.isEmpty();
    }

    public boolean lastTokenIsDigit() {
        return !tokens.isEmpty() && tokens.getLast() instanceof DigitToken;
    }

    public boolean lastTokenIsOperation() {
        return !tokens.isEmpty() && tokens.getLast() instanceof MathOperationToken;
    }

    public boolean isOpenedBracket() {
        return unclosedBrackets > 0;
    }

    public void closeBracket() {
        unclosedBrackets--;
    }

    public void openBracket() {
        unclosedBrackets++;
    }

    public void deleteLastToken() {
        tokens.removeLast();
    }

    public void clearTokens() {
        unclosedBrackets = 0;
        tokens.clear();
    }

    private boolean canBeAdded() {
        return !isEmpty() && !lastTokenIsOperation() && getLastToken() != OPENED_BRACKET;
    }

    private boolean isUnary() {
        return isEmpty() || getLastToken() == OPENED_BRACKET;
    }
}

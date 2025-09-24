package com.ivanov.antony.tokenizer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MathOperationToken implements OperationToken {

    MINUS('-'),
    PLUS('+'),
    DIVIDE('/'),
    MULTIPLY('*'),
    MOD('%');

    private final char value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public char getValue() {
        return value;
    }
}

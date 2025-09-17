package com.ivanov.antony.tokenizer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BracketToken implements OperationToken {

    OPENED_BRACKET('('),
    CLOSED_BRACKET(')');

    private final char value;

    @Override
    public char getValue() {
        return value;
    }
}

package com.ivanov.antony.tokenizer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SpecialTokens implements Token {

    UNARY_MINUS('-'),
    DOT('.');

    private final char value;

}

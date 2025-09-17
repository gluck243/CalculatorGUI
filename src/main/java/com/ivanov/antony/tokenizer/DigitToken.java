package com.ivanov.antony.tokenizer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DigitToken implements Token {

    private final int digit;

    public char getValue() {
        return (char) (digit + '0');
    }
}

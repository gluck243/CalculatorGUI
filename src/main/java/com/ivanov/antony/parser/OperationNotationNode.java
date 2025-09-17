package com.ivanov.antony.parser;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.BiFunction;

@AllArgsConstructor
public enum OperationNotationNode implements Node {

    MINIS('-', 1, (a, b) -> a - b),
    PLUS('+', 1, (a, b) -> a + b),
    DIVIDE('/', 2, (a, b) -> a / b),
    MULTIPLY('*', 2, (a, b) -> a * b),
    MOD('%', 2, (a, b) -> a % b),
    BRACKET_NODE('(', 0, (a, b) -> {
        throw new IllegalStateException("Not supported operation");
    });

    private final char value;
    @Getter
    private final int precedence;
    private final BiFunction<Double, Double, Double> operation;

    public double apply(double first, double second) {
        return operation.apply(first, second);
    }
}

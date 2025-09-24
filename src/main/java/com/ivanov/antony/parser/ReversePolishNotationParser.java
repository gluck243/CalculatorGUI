package com.ivanov.antony.parser;

import com.ivanov.antony.tokenizer.BracketToken;
import com.ivanov.antony.tokenizer.DigitToken;
import com.ivanov.antony.tokenizer.MathOperationToken;
import com.ivanov.antony.tokenizer.Token;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static com.ivanov.antony.parser.OperationNotationNode.BRACKET_NODE;
import static com.ivanov.antony.tokenizer.BracketToken.CLOSED_BRACKET;
import static com.ivanov.antony.tokenizer.BracketToken.OPENED_BRACKET;
import static com.ivanov.antony.tokenizer.MathOperationToken.MINUS;
import static com.ivanov.antony.tokenizer.SpecialTokens.DOT;
import static com.ivanov.antony.tokenizer.SpecialTokens.UNARY_MINUS;

public class ReversePolishNotationParser implements Parser {

    public List<Node> parse(Deque<Token> tokens) {
        ArrayList<Token> tokenList = new ArrayList<>(tokens);
        Deque<OperationNotationNode> operatorDeque = new LinkedList<>();
        List<Node> polishNotation = new ArrayList<>();
        for (int i = 0; i < tokenList.size(); i++) {
            Token token = tokenList.get(i);
            if (token instanceof BracketToken bracketToken) {
                shuntingYard(bracketToken, operatorDeque, polishNotation);
            } else if (token instanceof MathOperationToken operationToken) {
                shuntingYard(operationToken, operatorDeque, polishNotation);
            } else if (token instanceof DigitToken || token == UNARY_MINUS) {
                if (token == UNARY_MINUS && (operatorDeque.isEmpty() && polishNotation.isEmpty())) {
                    shuntingYard(0, polishNotation);
                    shuntingYard(MINUS, operatorDeque, polishNotation);
                }
                else {
                    StringBuilder numberBuilder = new StringBuilder().append(token.getValue());
                    while (i + 1 < tokens.size() && (tokenList.get(i + 1) instanceof DigitToken || tokenList.get(i + 1) == DOT)) {
                        numberBuilder.append(tokenList.get(i + 1).getValue());
                        i++;
                    }
                    shuntingYard(Double.parseDouble(numberBuilder.toString()), polishNotation);
                }
            }
        }
        finalCleanup(operatorDeque, polishNotation); // Push the rest of the operatorStack to the output list
        return polishNotation;
    }

    private void shuntingYard(BracketToken token, Deque<OperationNotationNode> operatorDeque, List<Node> polishNotation) {
        if (token == OPENED_BRACKET) {
            operatorDeque.addLast(BRACKET_NODE);
        } else if (token == CLOSED_BRACKET) {
            while (!operatorDeque.isEmpty() && operatorDeque.getLast() != BRACKET_NODE) {
                polishNotation.add(operatorDeque.removeLast());
            }
            if (!operatorDeque.isEmpty()) {
                operatorDeque.removeLast(); // changed from RemoveFirst
            }
        }
    }

    private void shuntingYard(MathOperationToken token, Deque<OperationNotationNode> operatorDeque, List<Node> polishNotation) {
        OperationNotationNode operationNode = tokenToOperation(token);
        while (!operatorDeque.isEmpty() && hasGreaterOrEqualPrecedence(operatorDeque.getLast(), operationNode)) {
            polishNotation.add(operatorDeque.removeLast()); // changed from RemoveFirst
        }
        operatorDeque.addLast(operationNode); // changed from push
    }

    private void shuntingYard(double number, List<Node> polishNotation) {
        polishNotation.add(new NumberNotationNode(number));
    }

    static void finalCleanup(Deque<OperationNotationNode> operatorDeque, List<Node> polishNotation) {
        while (!operatorDeque.isEmpty()) {
            polishNotation.add(operatorDeque.removeLast());
        }
    }

    private boolean hasGreaterOrEqualPrecedence(OperationNotationNode operatorFromStack, OperationNotationNode currentOperator) {
        return operatorFromStack.getPrecedence() >= currentOperator.getPrecedence();
    }

    private OperationNotationNode tokenToOperation(MathOperationToken token) {
        return switch (token) {
            case MINUS -> OperationNotationNode.MINIS;
            case PLUS -> OperationNotationNode.PLUS;
            case MULTIPLY -> OperationNotationNode.MULTIPLY;
            case DIVIDE -> OperationNotationNode.DIVIDE;
            case MOD -> OperationNotationNode.MOD;
        };
    }

}
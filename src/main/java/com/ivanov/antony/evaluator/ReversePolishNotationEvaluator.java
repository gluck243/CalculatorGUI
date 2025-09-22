package com.ivanov.antony.evaluator;

import com.ivanov.antony.parser.Node;
import com.ivanov.antony.parser.NumberNotationNode;
import com.ivanov.antony.parser.OperationNotationNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReversePolishNotationEvaluator implements Evaluator {

    public double evaluate(List<Node> polishNotation) {
        Deque<Double> loader = new LinkedList<>();
        for (Node notationNode : polishNotation) {
            if (notationNode instanceof NumberNotationNode numberNode) {
                loader.push(numberNode.getValue());
            } else if (notationNode instanceof OperationNotationNode operationNode) {
                if (loader.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: not enough operands.");
                }
                double operand2 = loader.removeFirst();
                double operand1 = loader.removeFirst();
                loader.addFirst(operationNode.apply(operand1, operand2));
            } else {
                throw new IllegalArgumentException("Invalid postfix expression: unsupported node type: " + notationNode.getClass());
            }
        }
        return loader.removeFirst();
    }
}

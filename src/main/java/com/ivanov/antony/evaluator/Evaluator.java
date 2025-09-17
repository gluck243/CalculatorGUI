package com.ivanov.antony.evaluator;

import com.ivanov.antony.parser.Node;

import java.util.List;

public interface Evaluator {

    double evaluate(List<Node> nodes);

}

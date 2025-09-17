package com.ivanov.antony.parser;

import com.ivanov.antony.tokenizer.Token;

import java.util.Deque;
import java.util.List;

public interface Parser {

    List<Node> parse(Deque<Token> tokens);

}

package com.ivanov.antony;

import com.ivanov.antony.buttons.*;
import com.ivanov.antony.evaluator.ReversePolishNotationEvaluator;
import com.ivanov.antony.parser.ReversePolishNotationParser;
import com.ivanov.antony.tokenizer.Tokenizer;

import javax.swing.*;
import java.awt.*;

import static com.ivanov.antony.tokenizer.MathOperationToken.*;

public class CalculatorFrame extends JFrame {

    // Constructor body
    public CalculatorFrame() {
        this.setTitle("Calculator"); // title declaration
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closing window on x press
        this.setSize(600, 600); // window size
        this.setResizable(false); // not resizable
        this.setLayout(new BorderLayout()); // border layout to safely arrange panels

        // JPanel declarations
        JPanel buttonPanel = new JPanel();
        JPanel operationPanel = new JPanel();
        JPanel displayPanel = new JPanel();

        // CardLayout Setup
        CardLayout cardLayout = new CardLayout();
        JPanel parenPanelContainer = new JPanel(cardLayout);
        JPanel autoModePanel = new JPanel(new GridLayout(1, 1)); // Fills the space
        JPanel manualModePanel = new JPanel(new GridLayout(1, 2)); // Two buttons side-by-side
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        JPanel swapButtonPanel = new JPanel(new BorderLayout()); // Small panel to keep the swap button small

        // Setting layouts of declared panels (first arg = rows, second arg = columns)
        buttonPanel.setLayout(new GridLayout(4, 3));
        operationPanel.setLayout(new GridLayout(4, 2));
        displayPanel.setLayout(new GridLayout());

        // Addition of button elements to the button panel
        JTextField output = new JTextField();
        Tokenizer tokenizer = new Tokenizer();

        buttonPanel.add(new InputButton("7", () -> tokenizer.addDigit(7), output));
        buttonPanel.add(new InputButton("8", () -> tokenizer.addDigit(8), output));
        buttonPanel.add(new InputButton("9", () -> tokenizer.addDigit(9), output));
        buttonPanel.add(new InputButton("4", () -> tokenizer.addDigit(4), output));
        buttonPanel.add(new InputButton("5", () -> tokenizer.addDigit(5), output));
        buttonPanel.add(new InputButton("6", () -> tokenizer.addDigit(6), output));
        buttonPanel.add(new InputButton("1", () -> tokenizer.addDigit(1), output));
        buttonPanel.add(new InputButton("2", () -> tokenizer.addDigit(2), output));
        buttonPanel.add(new InputButton("3", () -> tokenizer.addDigit(3), output));
        buttonPanel.add(new InputButton("0", () -> tokenizer.addDigit(0), output));


        buttonPanel.add(new InputButton(".", tokenizer::addDot, output));
        buttonPanel.add(new DeleteButton("/icons/DelButtonIcon.png", tokenizer, output));

        // Addition of functional buttons to operation panel
        operationPanel.add(new ClearButton(tokenizer, output));
        operationPanel.add(wrapperPanel);
        // operationPanel.add(buttonBrackets);
        autoModePanel.add(new InputButton("( )", tokenizer::addBracket, output));
        manualModePanel.add(new InputButton("(", tokenizer::addOpenedBracket, output));
        manualModePanel.add(new InputButton(")", tokenizer::addClosedBracket, output));
        parenPanelContainer.add(autoModePanel, "AUTO");
        parenPanelContainer.add(manualModePanel, "MANUAL");
        swapButtonPanel.add(new SwapButton("/icons/SwapArrowsIcon.png", cardLayout, parenPanelContainer));
        wrapperPanel.add(swapButtonPanel, BorderLayout.NORTH);
        wrapperPanel.add(parenPanelContainer, BorderLayout.CENTER);
        operationPanel.add(new InputButton("+", () -> tokenizer.addMathOperation(PLUS), output));
        operationPanel.add(new InputButton("-", () -> tokenizer.addMathOperation(MINIS), output));
        operationPanel.add(new InputButton("*", () -> tokenizer.addMathOperation(MULTIPLY), output));
        operationPanel.add(new InputButton("/", () -> tokenizer.addMathOperation(DIVIDE), output));
        operationPanel.add(new InputButton("%", () -> tokenizer.addMathOperation(MOD), output));
        operationPanel.add(new EqualsButton(tokenizer, new ReversePolishNotationParser(), new ReversePolishNotationEvaluator(), output));

        // text panel settings
        output.setFont(new Font("Arial", Font.PLAIN, 50)); // sets text font and size
        output.setEditable(false); // disables editing by user
        displayPanel.add(output);


        // Styling panels (width, height)
        buttonPanel.setPreferredSize(new Dimension(400, 400));
        operationPanel.setPreferredSize(new Dimension(200, 400));
        displayPanel.setPreferredSize(new Dimension(600, 200));
        operationPanel.setBackground(new Color(66, 135, 245));
        displayPanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(new Color(36, 75, 138));
        autoModePanel.setBackground(new Color(66, 135, 245));
        manualModePanel.setBackground(new Color(66, 135, 245));
        swapButtonPanel.setBackground(new Color(66, 135, 245));

        // Panel addition to the frame with layout position
        this.add(operationPanel, BorderLayout.EAST);
        this.add(displayPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.WEST);

        this.pack(); // makes all elements compact
        this.setVisible(true); // visibility of the frame
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonMultiplication = new JButton("X");
    JButton buttonDivision = new JButton("/");
    JButton buttonEquals = new JButton("=");
    JButton buttonDiv = new JButton("%");
    JButton buttonBrackets = new JButton("()");
    JButton buttonClear = new JButton("Clear");
    JButton buttonNumber1 = new JButton("1");
    JButton buttonNumber2 = new JButton("2");
    JButton buttonNumber3 = new JButton("3");
    JButton buttonNumber4 = new JButton("4");
    JButton buttonNumber5 = new JButton("5");
    JButton buttonNumber6 = new JButton("6");
    JButton buttonNumber7 = new JButton("7");
    JButton buttonNumber8 = new JButton("8");
    JButton buttonNumber9 = new JButton("9");
    JButton buttonNumber0 = new JButton("0");
    // JButton buttonNumber00 = new JButton("00");
    JButton buttonDot = new JButton(".");
    JButton buttonDelete = new JButton("Delete");
    CalculatorFrame() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JPanel operationPanel = new JPanel();
        JPanel displayPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(4, 3));
        operationPanel.setLayout(new GridLayout(4, 2));

        buttonNumber0.addActionListener(this);
        buttonNumber1.addActionListener(this);
        buttonNumber2.addActionListener(this);
        buttonNumber3.addActionListener(this);
        buttonNumber4.addActionListener(this);
        buttonNumber5.addActionListener(this);
        buttonNumber6.addActionListener(this);
        buttonNumber7.addActionListener(this);
        buttonNumber8.addActionListener(this);
        buttonNumber9.addActionListener(this);
        buttonNumber0.addActionListener(this);
        // buttonNumber00.addActionListener(this);
        buttonDot.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonMultiplication.addActionListener(this);
        buttonDivision.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonBrackets.addActionListener(this);

        buttonPanel.add(buttonNumber1);
        buttonPanel.add(buttonNumber2);
        buttonPanel.add(buttonNumber3);
        buttonPanel.add(buttonNumber4);
        buttonPanel.add(buttonNumber5);
        buttonPanel.add(buttonNumber6);
        buttonPanel.add(buttonNumber7);
        buttonPanel.add(buttonNumber8);
        buttonPanel.add(buttonNumber9);
        buttonPanel.add(buttonNumber0);
        // buttonPanel.add(buttonNumber00);
        buttonPanel.add(buttonDot);
        buttonPanel.add(buttonDelete);

        operationPanel.add(buttonClear);
        operationPanel.add(buttonBrackets);
        operationPanel.add(buttonPlus);
        operationPanel.add(buttonMinus);
        operationPanel.add(buttonMultiplication);
        operationPanel.add(buttonDivision);
        operationPanel.add(buttonDiv);
        operationPanel.add(buttonEquals);

        buttonPanel.setPreferredSize(new Dimension(400,400));
        operationPanel.setPreferredSize(new Dimension(200,400));
        displayPanel.setPreferredSize(new Dimension(600, 200));

        operationPanel.setBackground(new Color(66, 135, 245));
        displayPanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(new Color(36, 75, 138));

        this.add(operationPanel, BorderLayout.EAST);
        this.add(displayPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.WEST);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

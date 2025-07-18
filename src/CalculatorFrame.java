import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CalculatorFrame extends JFrame implements  KeyListener {

    double argument = 0.0; // argument that will be operated
    char operator = '+'; // operator
    boolean carryOn = false; // permission to carry on

    // Lots of JButton declarations
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
    JButton buttonDelete = new JButton("Delete"); // add icon

    JTextField text =  new JTextField(); // display text field declaration

    // Constructor body
    CalculatorFrame() {
        this.setTitle("Calculator"); // title declaration
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closing window on x press
        this.setSize(600, 600); // window size
        this.setResizable(false); // not resizable
        this.setLayout(new BorderLayout()); // border layout to safely arrange panels

        // JPanel declarations
        JPanel buttonPanel = new JPanel();
        JPanel operationPanel = new JPanel();
        JPanel displayPanel = new JPanel();

        // Setting layouts of declared panels (first arg = rows, second arg = columns)
        buttonPanel.setLayout(new GridLayout(4, 3));
        operationPanel.setLayout(new GridLayout(4, 2));
        displayPanel.setLayout(new GridLayout());

        // Addition of action listeners and their functionality through anon classes
        buttonNumber1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber1 && carryOn) {
                    text.setText("1");
                }
                else if (e.getSource() == buttonNumber1) {
                    text.setText(text.getText() + "1");
                }
            }
        });
        buttonNumber2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber2 && carryOn) {
                    text.setText("2");
                }
                else if (e.getSource() == buttonNumber2) {
                    text.setText(text.getText() + "2");
                }
            }
        });
        buttonNumber3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber3 && carryOn) {
                    text.setText("3");
                }
                else if (e.getSource() == buttonNumber3) {
                    text.setText(text.getText() + "3");
                }
            }
        });
        buttonNumber4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber4 && carryOn) {
                    text.setText("4");
                }
                else if (e.getSource() == buttonNumber4) {
                    text.setText(text.getText() + "4");
                }
            }
        });
        buttonNumber5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber5 && carryOn) {
                    text.setText("5");
                }
                else if (e.getSource() == buttonNumber5) {
                    text.setText(text.getText() + "5");
                }
            }
        });
        buttonNumber6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber6 && carryOn) {
                    text.setText("6");
                }
                else if (e.getSource() == buttonNumber6) {
                    text.setText(text.getText() + "6");
                }
            }
        });
        buttonNumber7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber7 && carryOn) {
                    text.setText("7");
                }
                else if (e.getSource() == buttonNumber7) {
                    text.setText(text.getText() + "7");
                }
            }
        });
        buttonNumber8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber8 && carryOn) {
                    text.setText("8");
                }
                else if (e.getSource() == buttonNumber8) {
                    text.setText(text.getText() + "8");
                }
            }
        });
        buttonNumber9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber9 && carryOn) {
                    text.setText("9");
                }
                else if (e.getSource() == buttonNumber9) {
                    text.setText(text.getText() + "9");
                }
            }
        });
        buttonNumber0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber0 && carryOn) {
                    text.setText("0");
                }
                else if  (e.getSource() == buttonNumber0) {
                    text.setText(text.getText() + "0");
                }
            }
        });
        // buttonNumber00.addActionListener(this);
        // Install fail safes to . (carryOn = false if nothing after the .)
        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonDot && text.getText().isEmpty()) {
                    text.setText("0.");
                }
                else if (e.getSource() == buttonDot) {
                    text.setText(text.getText() + ".");
                }
            }
        });

        // Work in progress!
        /* buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonDelete) {
                    argument = 0.0;
                    operator = '0';
                    carryOn = false;
                    text.setText("");
                }
            }
        });
         */

        /*
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonPlus) {
                    operation = "+";
                    carryOn = true;
                }
            }
        });
        buttonMinus.addActionListener(this);
        buttonMultiplication.addActionListener(this);
        buttonDivision.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonDelete) {
                    argument = 0.0;
                    operator = '0';
                    carryOn = false;
                    text.setText("");
                }
            }
        });
        buttonBrackets.addActionListener(this);
         */

        // Addition of button elements to the button panel
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

        // Addition of functional buttons to operation panel
        operationPanel.add(buttonClear);
        operationPanel.add(buttonBrackets);
        operationPanel.add(buttonPlus);
        operationPanel.add(buttonMinus);
        operationPanel.add(buttonMultiplication);
        operationPanel.add(buttonDivision);
        operationPanel.add(buttonDiv);
        operationPanel.add(buttonEquals);

        // text panel settings
        text.setEditable(false);
        displayPanel.add(text);

        // Styling panels (width, height)
        buttonPanel.setPreferredSize(new Dimension(400,400));
        operationPanel.setPreferredSize(new Dimension(200,400));
        displayPanel.setPreferredSize(new Dimension(600, 200));
        operationPanel.setBackground(new Color(66, 135, 245));
        displayPanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(new Color(36, 75, 138));

        // Panel addition to the frame with layout position
        this.add(operationPanel, BorderLayout.EAST);
        this.add(displayPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.WEST);

        this.pack(); // makes all elements compact
        this.setVisible(true); // visibility of the frame
    }

    // To be implemented
    @Override
    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //keyReleased = called whenever a button is released
    }
}

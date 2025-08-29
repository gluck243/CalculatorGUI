import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class CalculatorFrame extends JFrame implements  KeyListener {

    boolean beginAnew = false; // Allows display refreshment on '=' press
    int unclosed = 0; // Unclosed parenthesis counter

    // Lots of JButton declarations
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonMultiplication = new JButton("*");
    JButton buttonMod = new JButton("%");
    JButton buttonEquals = new JButton("=");
    JButton buttonDiv = new JButton("/");
    JButton swapModeButton = new JButton();
    JButton buttonBrackets = new JButton("( )");
    JButton openParenButton = new JButton("(");
    JButton closeParenButton = new JButton(")");
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
    JButton buttonDelete = new JButton();

    // Icon declarations
    ImageIcon deleteIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/DelButtonIcon.png")));
    ImageIcon swapIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/SwapArrowsIcon.png")));

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

        // Addition of action listeners and their functionality through anon classes
        buttonNumber1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber1 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("1");
                    // System.out.println("BeginAnew " + text.getText()); // debug
                }
                /*
                else if (e.getSource() == buttonNumber1 && carryOn) {
                    text.setText("1");
                    carryOn = false;
                    // System.out.println("CarryOn " + text.getText()); // debug
                }
                 */
                else if (e.getSource() == buttonNumber1) {
                    text.setText(text.getText() + "1");
                    // System.out.println(text.getText()); // debug
                }
            }
        });

        buttonNumber2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber2 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("2");
                }
                /*
                else if (e.getSource() == buttonNumber2 && carryOn) {
                    text.setText("2");
                    carryOn = false;
                }
                 */
                else if (e.getSource() == buttonNumber2) {
                    text.setText(text.getText() + "2");
                }
            }
        });

        buttonNumber3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber3 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("3");
                }
                /*
                else if (e.getSource() == buttonNumber3 && carryOn) {
                    carryOn = false;
                    text.setText("3");
                }
                 */
                else if (e.getSource() == buttonNumber3) {
                    text.setText(text.getText() + "3");
                }
            }
        });

        buttonNumber4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber4 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("4");
                }
                /*
                else if (e.getSource() == buttonNumber4 && carryOn) {
                    text.setText("4");
                    carryOn = false;
                }
                 */
                else if (e.getSource() == buttonNumber4) {
                    text.setText(text.getText() + "4");
                }
            }
        });

        buttonNumber5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber5 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("5");
                }
                /*
                else if (e.getSource() == buttonNumber5 && carryOn) {
                    text.setText("5");
                    carryOn = false;
                }
                 */
                else if (e.getSource() == buttonNumber5) {
                    text.setText(text.getText() + "5");
                }
            }
        });

        buttonNumber6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber6 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("6");
                }
                /*
                else if (e.getSource() == buttonNumber6 && carryOn) {
                    text.setText("6");
                    carryOn = false;
                }
                 */
                else if (e.getSource() == buttonNumber6) {
                    text.setText(text.getText() + "6");
                }
            }
        });

        buttonNumber7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber7 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("7");
                }
                /*
                else if (e.getSource() == buttonNumber7 && carryOn) {
                    text.setText("7");
                    carryOn = false;
                }
                 */
                else if (e.getSource() == buttonNumber7) {
                    text.setText(text.getText() + "7");
                }
            }
        });

        buttonNumber8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber8 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("8");
                }
                /*
                else if (e.getSource() == buttonNumber8 && carryOn) {
                    text.setText("8");
                    carryOn = false;
                }
                 */
                else if (e.getSource() == buttonNumber8) {
                    text.setText(text.getText() + "8");
                }
            }
        });

        buttonNumber9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber9 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("9");
                }
                /*
                else if (e.getSource() == buttonNumber9 && carryOn) {
                    text.setText("9");
                    carryOn = false;
                }
                 */
                else if (e.getSource() == buttonNumber9) {
                    text.setText(text.getText() + "9");
                }
            }
        });

        buttonNumber0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonNumber0 && beginAnew) {
                    Operations.allClear();
                    beginAnew = false;
                    text.setText("0");
                }
                /*
                else if (e.getSource() == buttonNumber0 && carryOn) {
                    text.setText("0");
                    carryOn = false;
                }
                 */
                else if (e.getSource() == buttonNumber0) {
                    text.setText(text.getText() + "0");
                }
            }
        });

        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonDot && text.getText().isEmpty()) {
                    text.setText("0.");
                }
                else if (e.getSource() == buttonDot) {
                    // carryOn = false; // turn off carryOn!!
                    text.setText(text.getText() + ".");
                    // System.out.println(text.getText());
                }
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonDelete) {
                    if (!text.getText().isEmpty()) {
                        text.setText(text.getText().substring(0, text.getText().length() - 1));
                    }
                }
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonPlus) {
                    /*
                    if (text.getText().equals("0.")) {
                        Operations.shuntingYard(Double.parseDouble("0.0"));
                    }
                    else if (!text.getText().equals(")")) {
                        Operations.shuntingYard(Double.parseDouble(text.getText()));
                    }
                    // checkMultipleOperators('+');
                    Operations.shuntingYard('+');
                    carryOn = true;
                     */
                    if (!text.getText().isEmpty() && !Operations.isOperator(text.getText().charAt(text.getText().length() - 1)) && text.getText().charAt(text.getText().length() - 1) != '(') {
                        text.setText(text.getText() + "+");
                    }
                }
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonMinus) {
                    /*
                    if (text.getText().equals("0.")) {
                        Operations.shuntingYard(Double.parseDouble("0.0"));
                        carryOn = true;
                        Operations.shuntingYard('-');
                    }
                    else if (text.getText().isEmpty() || text.getText().equals("(") ||
                            (text.getText().equals("+") || text.getText().equals("-") || text.getText().equals("*") || text.getText().equals("/") ||  text.getText().equals("%"))) {
                        System.out.println("Negative number incoming");
                        carryOn = false;
                    }
                    else if (!text.getText().equals(")")) {
                        Operations.shuntingYard(Double.parseDouble(text.getText()));
                        carryOn = true;
                        Operations.shuntingYard('-');
                    }
                     */
                    if (text.getText().isEmpty() || text.getText().charAt(text.getText().length() - 1) != '-') {
                        text.setText(text.getText() + "-");
                    }
                }
            }
        });

        buttonMultiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonMultiplication) {
                    /*
                    if (text.getText().equals("0.")) {
                        Operations.shuntingYard(Double.parseDouble("0.0"));
                    }
                    else if (!text.getText().equals(")")) {
                        Operations.shuntingYard(Double.parseDouble(text.getText()));
                    }
                    Operations.shuntingYard('*');
                    carryOn = true;
                     */
                    if (!text.getText().isEmpty() && !Operations.isOperator(text.getText().charAt(text.getText().length() - 1)) && text.getText().charAt(text.getText().length() - 1) != '(') {
                        text.setText(text.getText() + "*");
                    }
                }
            }
        });

        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonDiv) {
                    /*
                    if (text.getText().equals("0.")) {
                        Operations.shuntingYard(Double.parseDouble("0.0"));
                    }
                    else if (!text.getText().equals(")")) {
                        Operations.shuntingYard(Double.parseDouble(text.getText()));
                    }
                    Operations.shuntingYard('/');
                    carryOn = true;
                     */
                    if (!text.getText().isEmpty() && !Operations.isOperator(text.getText().charAt(text.getText().length() - 1)) && text.getText().charAt(text.getText().length() - 1) != '(') {
                        text.setText(text.getText() + "/");
                    }
                }
            }
        });

        buttonMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonMod) {
                    /*
                    if (text.getText().equals("0.")) {
                        Operations.shuntingYard(Double.parseDouble("0.0"));
                    }
                    else if (!text.getText().equals(")")) {
                        Operations.shuntingYard(Double.parseDouble(text.getText()));
                    }
                    Operations.shuntingYard('%');
                    carryOn = true;
                     */
                    if (!text.getText().isEmpty() && !Operations.isOperator(text.getText().charAt(text.getText().length() - 1)) && text.getText().charAt(text.getText().length() - 1) != '(') {
                        text.setText(text.getText() + "%");
                    }
                }
            }
        });

        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonEquals) {
                    /*
                    if (text.getText().equals("0.")) {
                        Operations.shuntingYard(Double.parseDouble("0.0"));
                    }
                    else if (!text.getText().equals(")")) {
                        Operations.shuntingYard(Double.parseDouble(text.getText()));
                    }
                     */
                    /*
                    Operations.finalCleanup();
                    double finalResult = Operations.calculate(Operations.outputList);
                    if (Double.isInfinite(finalResult) || Double.isNaN(finalResult)) {
                        text.setText("Error: Cannot divide by zero!");
                    }
                    else {
                        resultText = String.valueOf(Operations.unnecessaryDouble(finalResult));
                        text.setText(resultText);
                    }
                     */
                    // System.out.println(text.getText());
                    try {
                        // First, checking for mismatched parentheses before tokenizing.
                        if (unclosed != 0) {
                            throw new MismatchedParenthesesException("Brackets don't match.");
                        }

                        // Then, proceeding with tokenizing and calculation.
                        String result = Operations.tokenizer3000(text.getText());
                        text.setText(result);

                    } catch (MismatchedParenthesesException ex) {
                        text.setText("Error: Mismatched brackets");
                    } catch (IllegalArgumentException ex) {
                        text.setText("Error: Invalid expression");
                    } catch (Exception ex) {
                        // Final catch-all for any other unexpected error.
                        text.setText("An unknown error occurred");
                    }
                    beginAnew = true;
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonClear) {
                    // carryOn = false;
                    beginAnew = false;
                    unclosed = 0;
                    Operations.allClear();
                    text.setText("");
                }
            }
        });

        buttonBrackets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonBrackets) {
                    /*
                    if (e.getSource() == buttonBrackets && (text.getText().isEmpty() || text.getText().charAt(text.getText().length() - 1) == '(' || (text.getText().charAt(text.getText().length() - 1) == '+' || text.getText().charAt(text.getText().length() - 1) == '-' || text.getText().charAt(text.getText().length() - 1) == '*' || text.getText().charAt(text.getText().length() - 1) == '/' || text.getText().charAt(text.getText().length() - 1) == '%'))) {
                        // Operations.shuntingYard('(');
                        text.setText(text.getText() + "(");
                        // carryOn = true;
                        unclosed++;
                    }
                    else if (e.getSource() == buttonBrackets && unclosed > 0 && (Character.isDigit(text.getText().charAt(text.getText().length() - 1)) || text.getText().charAt(text.getText().length()) == ')')) {
                        // Operations.shuntingYard(Double.parseDouble(text.getText()));
                        // Operations.shuntingYard(')');
                        text.setText(text.getText() + ")");
                        // carryOn = true;
                        unclosed--;
                    }
                     */

                    char lastChar = ' ';
                    if (!text.getText().isEmpty()) {
                        lastChar = text.getText().charAt(text.getText().length() - 1);
                    }

                    if (unclosed > 0 && (Character.isDigit(lastChar) || lastChar == ')')) {
                        text.setText(text.getText() + ")");
                        unclosed--;
                        return;
                    }

                    if (Character.isDigit(lastChar) || lastChar == ')') {
                        text.setText(text.getText() + "*(");
                    } else {
                        text.setText(text.getText() + "(");
                    }
                    unclosed++;
                }
            }
        });

        openParenButton.addActionListener(e -> {
            text.setText(text.getText() + "(");
            unclosed++;
        });

        closeParenButton.addActionListener(e -> {
            if (unclosed > 0 && !Operations.isOperator(text.getText().charAt(text.getText().length() - 1)) && text.getText().charAt(text.getText().length() - 1) != '(') {
                text.setText(text.getText() + ")");
                unclosed--;
            }
        });

        swapModeButton.addActionListener(e -> {
            cardLayout.next(parenPanelContainer); // This line tells the CardLayout to show the next card
        });

        // Addition of button elements to the button panel
        buttonPanel.add(buttonNumber7);
        buttonPanel.add(buttonNumber8);
        buttonPanel.add(buttonNumber9);
        buttonPanel.add(buttonNumber4);
        buttonPanel.add(buttonNumber5);
        buttonPanel.add(buttonNumber6);
        buttonPanel.add(buttonNumber1);
        buttonPanel.add(buttonNumber2);
        buttonPanel.add(buttonNumber3);
        buttonPanel.add(buttonNumber0);
        // buttonPanel.add(buttonNumber00);
        buttonPanel.add(buttonDot);
        buttonPanel.add(buttonDelete);

        // Addition of functional buttons to operation panel
        operationPanel.add(buttonClear);
        operationPanel.add(wrapperPanel);
        // operationPanel.add(buttonBrackets);
        autoModePanel.add(buttonBrackets);
        manualModePanel.add(openParenButton);
        manualModePanel.add(closeParenButton);
        parenPanelContainer.add(autoModePanel, "AUTO");
        parenPanelContainer.add(manualModePanel, "MANUAL");
        swapButtonPanel.add(swapModeButton);
        wrapperPanel.add(swapButtonPanel, BorderLayout.NORTH);
        wrapperPanel.add(parenPanelContainer, BorderLayout.CENTER);
        operationPanel.add(buttonPlus);
        operationPanel.add(buttonMinus);
        operationPanel.add(buttonMultiplication);
        operationPanel.add(buttonDiv);
        operationPanel.add(buttonMod);
        operationPanel.add(buttonEquals);

        // Example of Button Styling
        buttonNumber1.setContentAreaFilled(false); // Disables painting of the content area
        // buttonNumber1.setBorderPainted(false); // Disables painting of the border
        buttonNumber1.setFocusPainted(false); // Disables the focus indicator (dotted line)
        buttonNumber1.setForeground(Color.WHITE); // Set text color to be visible on the background
        buttonNumber1.setFont(new Font("Arial", Font.BOLD, 20)); // Font Setup

        buttonNumber2.setContentAreaFilled(false);
        buttonNumber2.setFocusPainted(false);
        buttonNumber2.setForeground(Color.WHITE);
        buttonNumber2.setFont(new Font("Arial", Font.BOLD, 20));

        buttonNumber3.setContentAreaFilled(false);
        buttonNumber3.setFocusPainted(false);
        buttonNumber3.setForeground(Color.WHITE);
        buttonNumber3.setFont(new Font("Arial", Font.BOLD, 20));

        buttonNumber4.setContentAreaFilled(false);
        buttonNumber4.setFocusPainted(false);
        buttonNumber4.setForeground(Color.WHITE);
        buttonNumber4.setFont(new Font("Arial", Font.BOLD, 20));

        buttonNumber5.setContentAreaFilled(false);
        buttonNumber5.setFocusPainted(false);
        buttonNumber5.setForeground(Color.WHITE);
        buttonNumber5.setFont(new Font("Arial", Font.BOLD, 20));

        buttonNumber6.setContentAreaFilled(false);
        buttonNumber6.setFocusPainted(false);
        buttonNumber6.setForeground(Color.WHITE);
        buttonNumber6.setFont(new Font("Arial", Font.BOLD, 20));

        buttonNumber7.setContentAreaFilled(false);
        buttonNumber7.setFocusPainted(false);
        buttonNumber7.setForeground(Color.WHITE);
        buttonNumber7.setFont(new Font("Arial", Font.BOLD, 20));

        buttonNumber8.setContentAreaFilled(false);
        buttonNumber8.setFocusPainted(false);
        buttonNumber8.setForeground(Color.WHITE);
        buttonNumber8.setFont(new Font("Arial", Font.BOLD, 20));

        buttonNumber9.setContentAreaFilled(false);
        buttonNumber9.setFocusPainted(false);
        buttonNumber9.setForeground(Color.WHITE);
        buttonNumber9.setFont(new Font("Arial", Font.BOLD, 20));

        buttonNumber0.setContentAreaFilled(false);
        buttonNumber0.setFocusPainted(false);
        buttonNumber0.setForeground(Color.WHITE);
        buttonNumber0.setFont(new Font("Arial", Font.BOLD, 20));

        buttonPlus.setContentAreaFilled(false);
        buttonPlus.setFocusPainted(false);
        buttonPlus.setForeground(Color.WHITE);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));

        buttonMinus.setContentAreaFilled(false);
        buttonMinus.setFocusPainted(false);
        buttonMinus.setForeground(Color.WHITE);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));

        buttonMultiplication.setContentAreaFilled(false);
        buttonMultiplication.setFocusPainted(false);
        buttonMultiplication.setForeground(Color.WHITE);
        buttonMultiplication.setFont(new Font("Arial", Font.BOLD, 20));

        buttonDiv.setContentAreaFilled(false);
        buttonDiv.setFocusPainted(false);
        buttonDiv.setForeground(Color.WHITE);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));

        buttonMod.setContentAreaFilled(false);
        buttonMod.setFocusPainted(false);
        buttonMod.setForeground(Color.WHITE);
        buttonMod.setFont(new Font("Arial", Font.BOLD, 20));

        buttonDot.setContentAreaFilled(false);
        buttonDot.setFocusPainted(false);
        buttonDot.setForeground(Color.WHITE);
        buttonDot.setFont(new Font("Arial", Font.BOLD, 20));

        buttonEquals.setContentAreaFilled(false);
        buttonEquals.setFocusPainted(false);
        buttonEquals.setForeground(Color.WHITE);
        buttonEquals.setFont(new Font("Arial", Font.BOLD, 20));

        // swapModeButton.setContentAreaFilled(false);
        swapModeButton.setFocusPainted(false);
        // swapModeButton.setBorderPainted(false);
        Image originalSwapImage = swapIcon.getImage(); // Extracts an image from an icon
        int desiredWidth = 24; // 24 pixels wide
        int desiredHeight = 24; // 24 pixels tall
        Image resizedSwapImage = originalSwapImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH); // Image resize
        ImageIcon resizedSwapIcon = new ImageIcon(resizedSwapImage); // Application
        swapModeButton.setIcon(resizedSwapIcon);
        swapModeButton.setMargin(new Insets(0, 0, 0, 0));
        // swapModeButton.setBorder(null);
        swapModeButton.setContentAreaFilled(false); // Setting transparent background
        // swapModeButton.setPreferredSize(new Dimension(30, 20));
        // swapModeButton.setForeground(Color.WHITE);
        // swapModeButton.setFont(new Font("Arial", Font.BOLD, 20));

        openParenButton.setContentAreaFilled(false);
        openParenButton.setFocusPainted(false);
        openParenButton.setForeground(Color.WHITE);
        openParenButton.setFont(new Font("Arial", Font.BOLD, 20));

        closeParenButton.setContentAreaFilled(false);
        closeParenButton.setFocusPainted(false);
        closeParenButton.setForeground(Color.WHITE);
        closeParenButton.setFont(new Font("Arial", Font.BOLD, 20));

        buttonBrackets.setContentAreaFilled(false);
        buttonBrackets.setFocusPainted(false);
        buttonBrackets.setForeground(Color.WHITE);
        buttonBrackets.setFont(new Font("Arial", Font.BOLD, 20));

        buttonClear.setContentAreaFilled(false);
        buttonClear.setFocusPainted(false);
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 20));

        // buttonDelete.setContentAreaFilled(false);
        buttonDelete.setFocusPainted(false);
        // buttonDelete.setBorderPainted(false);
        Image originalDeleteImage = deleteIcon.getImage();
        Image resizedDeleteImage = originalDeleteImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedDeleteIcon = new ImageIcon(resizedDeleteImage);
        buttonDelete.setIcon(resizedDeleteIcon);
        buttonDelete.setMargin(new Insets(0, 0, 0, 0));
        // buttonDelete.setBorder(null);
        buttonDelete.setContentAreaFilled(false); // transparent background
        // buttonDelete.setForeground(Color.WHITE);
        // buttonDelete.setFont(new Font("Arial", Font.BOLD, 20));

        // text panel settings
        text.setFont(new Font("Arial", Font.PLAIN, 50)); // sets text font and size
        text.setEditable(false); // disables editing by user
        displayPanel.add(text);


        // Styling panels (width, height)
        buttonPanel.setPreferredSize(new Dimension(400,400));
        operationPanel.setPreferredSize(new Dimension(200,400));
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

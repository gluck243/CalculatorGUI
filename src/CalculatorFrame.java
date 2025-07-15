import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    CalculatorFrame() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JPanel operationPanel = new JPanel();
        JPanel displayPanel = new JPanel();

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
}

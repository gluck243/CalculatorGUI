package com.ivanov.antony.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AbstractButton extends JButton {

    public AbstractButton(String text, ActionListener action) {
        this(action);
        this.setText(text);
    }

    public AbstractButton(ActionListener action) {
        this.addActionListener(action);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
//        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }
}

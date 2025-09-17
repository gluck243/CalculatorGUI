package com.ivanov.antony.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ButtonWithImage extends AbstractButton {

    public ButtonWithImage(String iconPath, ActionListener action) {
        super(action);
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(iconPath)));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
    }
}

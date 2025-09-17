package com.ivanov.antony.buttons;

import javax.swing.*;
import java.awt.*;

public class SwapButton extends ButtonWithImage {

    public SwapButton(String iconPath, CardLayout cardLayout, JPanel parenPanelContainer) {
        super(iconPath, event -> {
            cardLayout.next(parenPanelContainer);
        });
    }
}
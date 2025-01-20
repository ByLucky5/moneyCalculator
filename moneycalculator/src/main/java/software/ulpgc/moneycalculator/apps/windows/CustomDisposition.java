package software.ulpgc.moneycalculator.apps.windows;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CustomDisposition {

    public CustomDisposition() {
    }

    public JTextField customizeTextField(JTextField textField) {
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBorder(null);
        textField.setColumns(20);
        textField.setOpaque(false);
        return textField;
    }

    public JButton customizeButton(JButton button, int width, int height) {
        button.setForeground(Color.black);
        button.setBorder(new LineBorder(Color.black, 3, true));
        button.setBackground(new Color(100, 100, 100));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(width, height));
        return button;
    }
    public JComboBox<Currency> customizeComboBox(JComboBox<Currency> selector) {
        selector.setBackground(new Color(200, 200, 200));
        selector.setBorder(new LineBorder(Color.orange, 3));
        selector.setPreferredSize(new Dimension(370, 35));
        selector.setMaximumSize(new Dimension(370, 35));
        selector.setMaximumRowCount(5);
        return selector;
    }

    public JPanel customizePanel(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(new LineBorder(Color.black, 3));
        panel.setBackground(new Color(100, 100, 100));
        panel.setPreferredSize(new Dimension(280, 40));
        panel.setBackground(Color.white);
        return panel;
    }
}
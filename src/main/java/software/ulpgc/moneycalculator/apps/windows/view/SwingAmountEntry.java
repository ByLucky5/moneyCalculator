package software.ulpgc.moneycalculator.apps.windows.view;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SwingAmountEntry extends JTextField {

    private static final String PLACEHOLDER = "Enter amount";

    public SwingAmountEntry() {

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(PLACEHOLDER)) setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().trim().isEmpty()) setText(PLACEHOLDER);
            }
        });
    }
}

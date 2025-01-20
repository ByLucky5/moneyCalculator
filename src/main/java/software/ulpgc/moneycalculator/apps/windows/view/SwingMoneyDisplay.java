package software.ulpgc.moneycalculator.apps.windows.view;

import software.ulpgc.moneycalculator.apps.windows.CustomDisposition;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.model.Money;
import software.ulpgc.moneycalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Locale;
import java.util.Map;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {

    private JTextField amountField;
    private final SwingCurrencyDialog currencyDialog;
    private JPanel currencyToolbar;

    public SwingMoneyDisplay() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(100, 100, 100));
        this.setBorder(new LineBorder(Color.black, 4, true));
        add(this.currencyDialog = createCurrencyDialog());
        add(Box.createVerticalStrut(75));
        add(resultTextField());
        add(Box.createVerticalStrut(75));
        add(createCurrencyToolbar());
    }

    private JPanel resultTextField() {
        JPanel panel = new CustomDisposition().customizePanel(new JPanel());
        panel.add(this.amountField = new CustomDisposition().customizeTextField(new JTextField()));
        this.amountField.setEditable(false);
        return panel;
    }

    private SwingCurrencyDialog createCurrencyDialog() {
        return new SwingCurrencyDialog();
    }

    private JPanel createCurrencyToolbar() {
        currencyToolbar = new JPanel();
        currencyToolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        currencyToolbar.setOpaque(false);
        return currencyToolbar;
    }

    public MoneyDisplay define(Map<String, Currency> currencies) {
        this.currencyDialog.define(currencies);
        return this;
    }

    private double toDouble(String text) {
        return text.isEmpty() ? 0 : Double.parseDouble(text);
    }

    @Override
    public Money get() {
        return new Money(toDouble(amountField.getText()), currencyDialog.get());
    }

    @Override
    public MoneyDisplay set(Money money) {
        amountField.setText(String.format(Locale.US, "%.4f", money.amount()));
        return this;
    }
}


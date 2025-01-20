package software.ulpgc.moneycalculator.apps.windows.view;

import software.ulpgc.moneycalculator.apps.windows.CustomDisposition;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.view.CurrencyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private JComboBox<Currency> currencySelector;
    private Map<String, Currency> currencies;

    public SwingCurrencyDialog() {
        setLayout(new FlowLayout());
        setOpaque(false);
    }

    @Override
    public CurrencyDialog define(Map<String, Currency> currencies) {
        this.currencies = new TreeMap<>(currencies);
        add(createCurrencySelector());
        return this;
    }

    private Component createCurrencySelector() {
        this.currencySelector = new CustomDisposition().customizeComboBox(new JComboBox<>());
        updateCurrencySelector();
        return currencySelector;
    }

    private void updateCurrencySelector() {
        currencySelector.removeAllItems();
        currencies.values().forEach(currency -> currencySelector.addItem(currency));
        changeCurrencyFormat(SwingCurrencyCellRenderer.Format.NAME);
    }

    public void changeCurrencyFormat(SwingCurrencyCellRenderer.Format format) {
        currencySelector.setRenderer(new SwingCurrencyCellRenderer(format));
        repaint();
    }

    @Override
    public Currency get() {
        return currencySelector.getItemAt(currencySelector.getSelectedIndex());}
}

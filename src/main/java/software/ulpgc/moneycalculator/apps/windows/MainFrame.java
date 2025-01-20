package software.ulpgc.moneycalculator.apps.windows;

import software.ulpgc.moneycalculator.apps.windows.view.SwingMoneyDialog;
import software.ulpgc.moneycalculator.apps.windows.view.SwingMoneyDisplay;
import software.ulpgc.moneycalculator.architecture.control.Command;
import software.ulpgc.moneycalculator.architecture.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String,Command> commands = new HashMap<>();
    private final SwingMoneyDialog moneyDialog;
    private final SwingMoneyDisplay moneyDisplay;

    public MainFrame() throws HeadlessException {
        this.setLayout(new BorderLayout());
        this.add(createNorthPanel(), BorderLayout.NORTH);
        this.add(createCenterPanel(this.moneyDialog = new SwingMoneyDialog(),
                this.moneyDisplay = new SwingMoneyDisplay()), BorderLayout.CENTER);
        this.add(toolbar(), BorderLayout.SOUTH);
    }

    private Component createNorthPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE,150));
        northPanel.setOpaque(false);

        return northPanel;
    }

    private JPanel createCenterPanel(SwingMoneyDialog moneyDialog, SwingMoneyDisplay moneyDisplay) {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setOpaque(false);

        centerPanel.add(moneyDialog);
        centerPanel.add(moneyDisplay);

        return centerPanel;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setOpaque(false);

        JButton exchangeRateButton = new CustomDisposition().customizeButton(new JButton("Calculate"), 300, 50);
        exchangeRateButton.addActionListener(e -> commands.get("exchange rate").execute());
        panel.add(exchangeRateButton);
        return panel;
    }

    public MainFrame add(Map<String, Command> commands) {
        for (String name : commands.keySet()) this.commands.put(name, commands.get(name));
        return this;
    }

    public SwingMoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public SwingMoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public MainFrame defineCurrencies(Map<String, Currency> load) {
        moneyDialog.define(load);
        moneyDisplay.define(load);
        return this;
    }

    public MainFrame initializeFrame() {
        this.setTitle("Money Calculator");
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(200,200,200));
        return this;
    }
}

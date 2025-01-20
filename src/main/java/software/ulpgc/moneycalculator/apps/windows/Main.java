package software.ulpgc.moneycalculator.apps.windows;

import software.ulpgc.moneycalculator.apps.windows.persistence.CustomCurrencyLoader;
import software.ulpgc.moneycalculator.apps.windows.persistence.CustomExchangeRateLoader;
import software.ulpgc.moneycalculator.architecture.control.*;
import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, Currency> currencies;
    private static MainFrame frame;

    public static void main(String[] args) throws IOException {
        createMainFrame().defineCurrencies(loadCurrencies())
                .add(generateCommands())
                .setVisible(true);
    }

    private static MainFrame createMainFrame() {
        return frame = new MainFrame().initializeFrame();
    }

    private static Map<String, Currency> loadCurrencies() throws IOException {
        return currencies = new CustomCurrencyLoader().load();
    }

    private static Map<String, Command> generateCommands() throws IOException {
        Map<String, Command> commands = new HashMap<>();
        commands.put("exchange rate", new ExchangeCommand(frame.getMoneyDialog(), frame.getMoneyDisplay(),
                        new CustomExchangeRateLoader(currencies).load()));
        return commands;
    }
}

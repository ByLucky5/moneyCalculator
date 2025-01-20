package software.ulpgc.moneycalculator.architecture.control;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculator.architecture.model.Money;
import software.ulpgc.moneycalculator.architecture.view.MoneyDialog;
import software.ulpgc.moneycalculator.architecture.view.MoneyDisplay;
import software.ulpgc.moneycalculator.apps.windows.view.SwingMoneyDisplay;

import java.util.Map;

public class ExchangeCommand implements Command {
    private final MoneyDialog dialog;
    private final MoneyDisplay display;
    private final Map<Currency, ExchangeRate> exchangeRateLoader;

    public ExchangeCommand(MoneyDialog dialog, SwingMoneyDisplay display, Map<Currency, ExchangeRate> exchangeRateLoader) {
        this.dialog = dialog;
        this.display = display;
        this.exchangeRateLoader = exchangeRateLoader;
    }

    @Override
    public void execute() {
        double rateFrom = exchangeRateLoader.get(dialog.get().currency()).rate();
        double rateTo = exchangeRateLoader.get(display.get().currency()).rate();

        double displayAmount = (dialog.get().amount() / rateFrom) * rateTo;

        display.set(new Money(displayAmount, display.get().currency()));
    }

}

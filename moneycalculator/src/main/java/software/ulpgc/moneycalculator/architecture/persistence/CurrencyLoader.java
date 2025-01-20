package software.ulpgc.moneycalculator.architecture.persistence;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.io.IOException;
import java.util.Map;

public interface CurrencyLoader {
    Map<String, Currency> load() throws IOException;
}

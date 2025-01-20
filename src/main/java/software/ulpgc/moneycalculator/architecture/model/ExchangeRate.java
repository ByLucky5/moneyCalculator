package software.ulpgc.moneycalculator.architecture.model;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, LocalDate date, double rate) {

    @Override
    public String toString() {
        return "ExchangeRate [" +
                "From = " + from + ", " +
                "To = " + to + ", " +
                "Date = " + date + ", " +
                "Rate = " + rate + ']';
    }

}

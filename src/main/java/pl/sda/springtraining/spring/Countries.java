package pl.sda.springtraining.spring;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Countries {
    POLAND("PL", "Polska"),
    GERMANY("DE", "Niemcy"),
    USA("USA", "Stany Zjednoczone Ameryki"),
    JAPAN("JP", "Japonia"),
    UK("UK", "Anglia");

    private final String symbol;
    private final String plName;

    Countries(String symbol, String plName) {
        this.symbol = symbol;
        this.plName = plName;
    }

    public static Countries findCountryBbySymbil(String symbol){
      return   Arrays.stream(Countries.values())
                .filter(e -> e.getSymbol().equals(symbol))
                .findFirst().orElse(null);
    }
}

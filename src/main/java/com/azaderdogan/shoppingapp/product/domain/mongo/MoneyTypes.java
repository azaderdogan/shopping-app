package com.azaderdogan.shoppingapp.product.domain.mongo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum MoneyTypes {
    USD("Dolar", "$"),
    EUR("EURO", "€"),
    TL("Türk Lirası", "TL");

    private final String label;
    private final String symbol;

    MoneyTypes(String label, String symbol) {
        this.label = label;
        this.symbol = symbol;
    }
}

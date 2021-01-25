package com.azaderdogan.shoppingapp.product.domain.mongo;

public enum MoneyTypes {
    USD("Dolar", "$"),
    EUR("EURO", "€"),
    TL("Türk Lirası", "TL");

    private String label;
    private String symbol;

    MoneyTypes(String label, String symbol) {
        this.label = label;
        this.symbol = symbol;
    }
}

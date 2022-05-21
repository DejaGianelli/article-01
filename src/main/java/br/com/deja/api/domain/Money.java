package br.com.deja.api.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class Money implements ValueObject {

    public static final Money ZERO = Money.create(0.00);

    private final int amount;

    private Money(int amount) {
        this.amount = Math.abs(amount);
    }

    private Money(double amount) {
        amount = Math.abs(amount);
        int decimalPoint = 2;
        amount = amount * Math.pow(10, decimalPoint);
        amount = Math.floor(amount);
        amount = amount / Math.pow(10, decimalPoint);
        this.amount = toCents(amount);
    }

    public static Money create(double amount) {
        return new Money(amount);
    }

    public static Money create(int amountInCents) {
        return new Money(amountInCents);
    }

    private int toCents(double amount) {
        return (int) (amount * 100);
    }

    public int getAmount() {
        return amount;
    }

    public double getDoubleAmount() {
        return (((double) this.amount) / 100);
    }

    @Override
    public String toString() {
        var nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        nf.setMinimumFractionDigits(2);
        return nf.format(getDoubleAmount());
    }
}

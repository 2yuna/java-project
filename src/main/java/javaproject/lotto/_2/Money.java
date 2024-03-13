package javaproject.lotto._2;

import java.text.DecimalFormat;

public class Money {

    public static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int toInt() {
        return amount;
    }

    public String toUnitMoney() {
        return MONEY_FORMAT.format(amount);
    }
}

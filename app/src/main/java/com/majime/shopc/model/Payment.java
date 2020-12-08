package com.majime.shopc.model;

public abstract class Payment {
    private int tax;

    public Payment() {
        this.tax = 2500;
    }

    public Payment(int tax) {
        this.tax = tax;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public abstract int calculate(int amountOfProduct);
}

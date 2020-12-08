package com.majime.shopc.model;

public abstract class Shipping {
    private int tax;

    public Shipping() {
        this.tax = 1000;
    }

    public Shipping(int tax) {
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

package com.majime.shopc.model;

abstract class Shipping {
    private int tax;

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public abstract int calculate(Product product);
}

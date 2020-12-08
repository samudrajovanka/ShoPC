package com.majime.shopc.model;

public class Debit extends Payment{
    private int tax;

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public int calculate(Product product) {
        return 0;
    }
}

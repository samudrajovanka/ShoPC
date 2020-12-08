package com.majime.shopc.model;

public class Cash extends Payment{
    public Cash() {
        super();
    }

    public Cash(int tax) {
        super(tax);
    }

    @Override
    public int calculate(int amountOfProduct) {
        int total = this.getTax() + ((this.getTax() * amountOfProduct)/100);

        return total;
    }

}

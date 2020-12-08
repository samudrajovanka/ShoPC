package com.majime.shopc.model;

public class Debit extends Payment{
    public Debit() {
        super();
    }

    public Debit(int tax) {
        super(tax);
    }

    @Override
    public int calculate(int amountOfProduct) {
        int total = this.getTax() + ((this.getTax() * amountOfProduct)/100);

        return total;
    }
}

package com.majime.shopc.model;

public class Jne extends Shipping{
    private boolean guarantee;

    public Jne() {
        super();
        this.guarantee = false;
    }

    public Jne(int tax, boolean guarantee) {
        super(tax);
        this.guarantee = guarantee;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public int calculate(int amountOfProduct) {
        int total = this.getTax() * amountOfProduct;
        return total;
    }
}

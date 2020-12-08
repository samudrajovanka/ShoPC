package com.majime.shopc.model;

public class JNE extends Shipping{
    private boolean guarantee;

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public int calculate(Product product) {
        return 0;
    }
}

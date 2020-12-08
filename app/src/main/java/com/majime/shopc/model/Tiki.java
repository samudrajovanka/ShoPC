package com.majime.shopc.model;

public class Tiki extends Shipping{
    private String services;

    public Tiki() {
        super();
        this.services = "Same Day";
    }

    public Tiki(int tax, String services) {
        super(tax);
        this.services = services;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    @Override
    public int calculate(int amountOfProduct) {
        int total = this.getTax() * amountOfProduct;

        if(amountOfProduct > 5) {
            total += 2000;
        }

        return total;
    }
}

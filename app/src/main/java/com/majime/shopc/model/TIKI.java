package com.majime.shopc.model;

public class TIKI extends Shipping{
    private String services;

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    @Override
    public int calculate(Product product) {
        return 0;
    }
}

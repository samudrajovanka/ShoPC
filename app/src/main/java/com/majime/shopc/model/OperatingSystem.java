package com.majime.shopc.model;

import java.util.Date;

public class OperatingSystem extends LicensedSoftware {
    private String type;

    public OperatingSystem(){
        super();
        this.type = "Type";
    }

    public OperatingSystem(String name, int price, int rating, int amount, int photo,
            String version, int size, String key, Date expiration, String type) {
        super(name, price, rating, amount, photo, version, size, key, expiration);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
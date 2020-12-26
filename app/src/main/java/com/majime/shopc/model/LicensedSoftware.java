package com.majime.shopc.model;

import java.util.Date;

public abstract class LicensedSoftware extends Software {
    private String key;
    private Date expiration;

    public LicensedSoftware(){
        super();
        this.key = "xxx";
        this.expiration = new Date();
    }

    public LicensedSoftware(String name, int price, int rating, int amount, int photo,
            String version, int size, String key, Date expiration) {
        super(name, price, rating, amount, photo, version, size);
        this.key = key;
        this.expiration = expiration;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

}

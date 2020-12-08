package com.majime.shopc.model;

import java.net.URI;
import java.sql.Date;

public abstract class LicensedSoftware extends Software {
    private String key;
    private Date expiration;

    public LicensedSoftware(){
        super();
    }

    public LicensedSoftware(String name, int price, URI photo, int rating, String version, int size, String key, Date expiration){
        super(name, price, photo, rating, version, size);
        this.key = key;
        this.expiration = expiration;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

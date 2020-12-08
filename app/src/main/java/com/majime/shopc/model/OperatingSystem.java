package com.majime.shopc.model;

import java.net.URI;
import java.sql.Date;

public class OperatingSystem extends LicensedSoftware {
    private String type;

    private OperatingSystem(){

    }

    public OperatingSystem(String name, int price, URI photo, int rating, String version, int size, String key, Date expiration, String type){
        super(name, price, photo, rating, version, size, key, expiration);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
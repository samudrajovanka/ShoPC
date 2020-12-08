package com.majime.shopc.model;

import java.net.URI;
import java.sql.Date;

public class Antivirus extends LicensedSoftware{
    private String developer;

    public Antivirus(){

    }

    public Antivirus(String name, int price, URI photo, int rating, String version, int size, String key, Date expiration, String developer){
        super(name, price, photo, rating, version, size, key, expiration);
        this.developer = developer;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

}
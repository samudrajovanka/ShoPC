package com.majime.shopc.model;

import java.net.URI;
import java.util.Date;

public class Antivirus extends LicensedSoftware{
    private String developer;

    public Antivirus(){
        super();
        this.developer = "developer";
    }

    public Antivirus(String name, int price, int rating, int amount, URI photo,
            String version, int size, String key, Date expiration, String developer) {
        super(name, price, rating, amount, photo, version, size, key, expiration);
        this.developer = developer;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

}
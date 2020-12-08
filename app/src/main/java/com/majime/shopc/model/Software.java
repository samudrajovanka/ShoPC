package com.majime.shopc.model;

import java.net.URI;

public abstract class Software extends Product {
    private String version;
    private int size;

    public Software(){
        super();
    }

    public Software(String name, int price, URI photo, int rating, String version, int size){
        super(name, price, photo, rating);
        this.version = version;
        this.size = size;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

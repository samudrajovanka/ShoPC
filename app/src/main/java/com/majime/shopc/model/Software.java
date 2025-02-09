package com.majime.shopc.model;

public abstract class Software extends Product {
    private String version;
    private int size;

    public Software(){
        super();
        this.version = "v.1";
        this.size = 0;
    }

    public Software(String name, int price, int rating, int amount, int photo,
                    String version, int size) {
        super(name, price, rating, amount, photo);
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

package com.majime.shopc.model;

public abstract class Hardware extends Product implements Dimension {

    private int weight, width, height, length;
    private String merk, type;

    public Hardware() {
        super();
        this.weight = 0;
        this.width = 0;
        this.height = 0;
        this.length = 0;
        this.merk = "Merk";
        this.type = "Type";
    }

    public Hardware(
            String name,
            int price,
            int rating,
            int amount,
            int photo,
            int weight,
            int width,
            int height,
            int length,
            String merk,
            String type
    ) {
        super(name, price, rating, amount, photo);
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
        this.merk = merk;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int getLength() {
        return this.length;
    }

}

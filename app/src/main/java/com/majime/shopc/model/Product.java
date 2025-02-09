package com.majime.shopc.model;

public abstract class Product {

    private String name;
    private int price, rating, amount, photo;

    public Product() {
        this.name = "Product";
        this.price = 0;
        this.rating = 0;
        this.amount = 0;
    }

    public Product(String name, int price, int rating, int amount, int photo) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.amount = amount;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}

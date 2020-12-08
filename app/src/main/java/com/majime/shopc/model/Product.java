package com.majime.shopc.model;

import java.net.URI;

public abstract class Product {
    private String name;
    private int price, rating, amount;
    private URI photo;

    public Product() {
        this.name = "Product";
        this.price = 0;
        this.rating = 0;
        this.amount = 0;
    }

    public Product(String name, int price, int rating, int amount, URI photo) {
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

    public URI getPhoto() {
        return photo;
    }

    public void setPhoto(URI photo) {
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

    public String getInfo() {
        return "Name: " + name +
                "\nPrice: " + price +
                "\nRating: " + rating +
                "\nPhoto: " + photo;
    }
}

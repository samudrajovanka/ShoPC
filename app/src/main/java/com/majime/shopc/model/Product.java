package com.majime.shopc.model;

import java.net.URI;

public abstract class Product {
    private String name;
    private int price, rating;
    private URI photo;

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

    public String getInfo() {
        return "Name: " + name +
                "\nPrice: " + price +
                "\nRating: " + rating +
                "\nPhoto: " + photo;
    }
}

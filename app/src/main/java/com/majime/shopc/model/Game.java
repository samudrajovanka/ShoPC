package com.majime.shopc.model;

import java.net.URI;

public class Game extends Software{
    private String genre;
    private String developer;

    public Game(){
        super();
        this.genre = "Genre";
        this.developer = "Developer";
    }

    public Game(String name, int price, int rating, int amount, URI photo, String version,
            int size, String genre, String developer) {
        super(name, price, rating, amount, photo, version, size);
        this.genre = genre;
        this.developer = developer;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

}
package com.majime.shopc.model;

import java.net.URI;

public class Game extends Software{
    private String genre;
    private String developer;

    public Game(){

    }
    public Game(String name, int price, URI photo, int rating, String version, int size, String genre, String developer){
        super(name, price, photo, rating, version, size);
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
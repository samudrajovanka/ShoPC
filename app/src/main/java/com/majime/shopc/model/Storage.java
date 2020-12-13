package com.majime.shopc.model;

import java.net.URI;

public class Storage extends Hardware implements Frequency, Memory {
    private int frequency;
    private String connection;
    private int sizeMemory;

    public Storage() {
        super();
        this.frequency = Frequency.FREQUENCY;
        this.connection = "SATA";
        this.sizeMemory = Memory.SIZE_MEMORY;
    }

    public Storage(String name, int price, int rating, int amount, int photo, int weight,
            int width, int height, int length, String merk, String type, int frequency,
            String connection, int sizeMemory) {
        super(name, price, rating, amount, photo, weight, width, height, length, merk, type);
        this.frequency = frequency;
        this.connection = connection;
        this.sizeMemory = sizeMemory;
    }

    @Override
    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    @Override
    public int getFrequency(){
        return this.frequency;
    }

    @Override
    public void setSizeMemory(int sizeMemory){
        this.sizeMemory = sizeMemory;
    }

    @Override
    public int getSizeMemory(){
        return this.sizeMemory;
    }

    public void setConnection(String connection){
        this.connection = connection;
    }

    public String getConnection(){
        return this.connection;
    }
}

package com.majime.shopc.model;

import java.net.URI;

public class Ram extends Hardware implements Memory, Frequency{
    private int frequency;
    private String DdrType;
    private int sizeMemory;

    public Ram() {
        this.frequency = Frequency.FREQUENCY;
        DdrType = "DDR3";
        this.sizeMemory = Memory.SIZE_MEMORY;
    }

    public Ram(String name, int price, int rating, int amount, URI photo, int weight, int width,
            int height, int length, String merk, String type, int frequency, String ddrType,
            int sizeMemory) {
        super(name, price, rating, amount, photo, weight, width, height, length, merk, type);
        this.frequency = frequency;
        DdrType = ddrType;
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

    public void setDdrType(String DdrType){
        this.DdrType = DdrType;
    }

    public String getDdrType(){
        return this.DdrType;
    }
}


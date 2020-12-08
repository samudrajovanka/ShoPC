package com.majime.shopc.model;

import java.net.URI;

public class Vga extends Hardware implements Frequency, Memory {
    private int frequency;
    private int sizeMemory;

    public Vga() {
        super();
        this.frequency = Frequency.FREQUENCY;
        this.sizeMemory = Memory.SIZE_MEMORY;
    }

    public Vga(String name, int price, int rating, int amount, URI photo, int weight, int width,
            int height, int length, String merk, String type, int frequency, int sizeMemory) {
        super(name, price, rating, amount, photo, weight, width, height, length, merk, type);
        this.frequency = frequency;
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
}

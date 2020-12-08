package com.majime.shopc.model;

public class Storage implements Frequency, Memory extends Hardware{
    private int frequency;
    private String connection;
    private int sizeMemory;

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

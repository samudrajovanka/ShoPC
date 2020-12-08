package com.majime.shopc.model;

public class RAM implements Memory, Frequency{
    private int frequency;
    private String DdrType;
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

    public void setDdrType(String DdrType){
        this.DdrType = DdrType;
    }

    public String getDdrType(){
        return this.DdrType;
    }
}


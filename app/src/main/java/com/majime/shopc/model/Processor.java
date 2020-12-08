package com.majime.shopc.model;

import java.net.URI;

public class Processor extends Hardware implements Socket, Frequency {
    private int pinAmount, frequency, coreAmount;
    private String supportedCpu;

    public Processor() {
        this.pinAmount = Socket.PIN_AMOUNT;
        this.frequency = Frequency.FREQUENCY;
        this.coreAmount = 2;
        this.supportedCpu = Socket.SUPPORTED_CPU;
    }

    public Processor(String name, int price, int rating, int amount, URI photo, int weight,
            int width, int height, int length, String merk, String type, int pinAmount,
            int frequency, int coreAmount, String supportedCpu) {
        super(name, price, rating, amount, photo, weight, width, height, length, merk, type);
        this.pinAmount = pinAmount;
        this.frequency = frequency;
        this.coreAmount = coreAmount;
        this.supportedCpu = supportedCpu;
    }

    public int getCoreAmount() {
        return this.coreAmount;
    }

    public void setCoreAmount(int coreAmount) {
        this.coreAmount = coreAmount;
    }

    @Override
    public void setFrequency(int Frequency) {
        this.frequency = frequency;
    }

    @Override
    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public void setPinAmount(int pinAmount) {
        this.pinAmount = pinAmount;
    }

    @Override
    public int getPinAmount() {
        return this.pinAmount;
    }

    @Override
    public void setSupportedCpu(String supportedCpu) {
        this.supportedCpu = supportedCpu;
    }

    @Override
    public String getSupportedCpu() {
        return this.supportedCpu;
    }

}

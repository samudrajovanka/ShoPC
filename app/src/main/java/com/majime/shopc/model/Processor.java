package com.majime.shopc.model;

public class Processor extends Hardware {
    private int pinAmount, frequency, coreAmount;
    private String supportedCpu;

    public int getCoreAmount() {
        return coreAmount;
    }

    public void setCoreAmount(int coreAmount) {
        this.coreAmount = coreAmount;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setLength(int length) {

    }

    @Override
    public int getLength() {
        return 0;
    }
}

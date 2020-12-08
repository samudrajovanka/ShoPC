package com.majime.shopc.model;

public class Motherboard extends Hardware{
    private int pinAmount, slotAmount;
    private String supportedCpu;

    public int getSlotAmount() {
        return slotAmount;
    }

    public void setSlotAmount(int slotAmount) {
        this.slotAmount = slotAmount;
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

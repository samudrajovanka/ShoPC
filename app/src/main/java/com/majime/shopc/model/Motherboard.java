package com.majime.shopc.model;

public class Motherboard extends Hardware implements Socket{
    private int pinAmount, slotAmount;
    private String supportedCpu;

    public Motherboard() {
        super();
        this.pinAmount = Socket.PIN_AMOUNT;
        this.slotAmount = 1;
        this.supportedCpu = Socket.SUPPORTED_CPU;
    }

    public Motherboard(String name, int price, int rating, int amount, int photo, int weight,
            int width, int height, int length, String merk, String type, int pinAmount,
            int slotAmount, String supportedCpu) {
        super(name, price, rating, amount, photo, weight, width, height, length, merk, type);
        this.pinAmount = pinAmount;
        this.slotAmount = slotAmount;
        this.supportedCpu = supportedCpu;
    }

    public int getSlotAmount() {
        return slotAmount;
    }

    public void setSlotAmount(int slotAmount) {
        this.slotAmount = slotAmount;
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

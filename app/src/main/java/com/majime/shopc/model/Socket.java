package com.majime.shopc.model;

public interface Socket {
    int PIN_AMOUNT = 40;
    String SUPPORTED_CPU = "DIP";

    void setPinAmount(int pinAmount);
    int getPinAmount();
    void setSupportedCpu(String supportedCpu);
    String getSupportedCpu();
}

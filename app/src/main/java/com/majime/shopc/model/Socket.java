package com.majime.shopc.model;

public interface Socket {
    public final int PIN_AMOUNT = 40;
    public final String SUPPORTED_CPU = "DIP";

    public void setPinAmount (int pinAmount);
    public int getPinAmount ();
    public void setSupportedCpu (String supportedCpu);
    public String getSupportedCpu ();
}

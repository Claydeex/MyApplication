package com.Fyto.UserApp;

public class ReadPlantData {

    private Long isConnected;
    private Long luxReading;

    public ReadPlantData(){

    }

    public String getLightIsConnected() {
        return String.valueOf(isConnected);
    }

    public void setLightIsConnected(Long isConnected) {
        this.isConnected = isConnected;
    }

    public String getLuxReading() {
        return String.valueOf(luxReading);
    }

    public void setLuxReading(Long luxReading) {
        this.luxReading = luxReading;
    }


}
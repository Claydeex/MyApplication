package com.Fyto.UserApp;

public class HomepageData {

    private Long isConnected;
    private Long humidityReading;
    private Long waterLevel;

    public HomepageData(){

    }

    public String getIsConnected() {
        return String.valueOf(isConnected);
    }

    public void setIsConnected(Long isConnected) {
        this.isConnected = isConnected;
    }

    public String getHumidityReading() {
        return String.valueOf(humidityReading);
    }

    public void setHumidityReading(Long humidityReading) {
        this.humidityReading = humidityReading;
    }

    public String getWaterLevel() {
        return String.valueOf(waterLevel);
    }

    public void setWaterLevel(Long waterLevel) {
        this.waterLevel = waterLevel;
    }
}
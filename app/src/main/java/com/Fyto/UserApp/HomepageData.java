package com.Fyto.UserApp;

public class HomepageData {

    private Boolean isConnected;
    private Long humidityReading;
    private Long waterLevel;
    private Long luxReading;

    public HomepageData(){

    }

    public Boolean getIsConnected() {
        return (isConnected);
    }

    public void setIsConnected(Boolean isConnected) {
        this.isConnected = isConnected;
    }

    public String getHumidityReading() {
        return String.valueOf(humidityReading);
    }

    public void setHumidityReading(Long humidityReading) {
        this.humidityReading = humidityReading;
    }

    public Integer getWaterLevel() {
        return waterLevel.intValue();
    }

    public void setWaterLevel(Long waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getLuxReading() {
        return String.valueOf(luxReading);
    }

    public void setLuxReading(Long luxReading) {
        this.luxReading = luxReading;
    }

}
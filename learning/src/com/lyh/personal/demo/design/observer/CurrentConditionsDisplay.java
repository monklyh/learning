package com.lyh.personal.demo.design.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(DataInfo data) {
        this.temperature = data.getTemp();
        this.humidity = data.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions ");
        System.out.println(" --Temperature(F degress): " + temperature);
        System.out.println(" --Humidity(%): " + humidity);
    }

}

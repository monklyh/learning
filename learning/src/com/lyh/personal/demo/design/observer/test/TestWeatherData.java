package com.lyh.personal.demo.design.observer.test;

import com.lyh.personal.demo.design.observer.CurrentConditionsDisplay;
import com.lyh.personal.demo.design.observer.DataInfo;
import com.lyh.personal.demo.design.observer.WeatherData;

public class TestWeatherData {
    public static void main(String[] args){
        DataInfo data = new DataInfo();
        data.setHumidity(32.2f);
        data.setTemp(22.1f);
        data.setPressure(94.3f);
        WeatherData w = new WeatherData();
        w.setDataInfo(data);
        CurrentConditionsDisplay c = new CurrentConditionsDisplay(w);
        c.update(data);


    }
}

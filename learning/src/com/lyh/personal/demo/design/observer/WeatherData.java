package com.lyh.personal.demo.design.observer;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private DataInfo data;
    private ArrayList<Observer> observers;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index > 0){
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update(data);
        }
    }

    public void dataInfoChanged(){
        notifyObservers();
    }

    public void setDataInfo(DataInfo changedData){
        data = changedData;
        dataInfoChanged();
    }

}

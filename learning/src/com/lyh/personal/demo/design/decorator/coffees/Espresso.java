package com.lyh.personal.demo.design.decorator.coffees;

import com.lyh.personal.demo.design.decorator.compoent.coffee.Beverage;

public class Espresso extends Beverage {

    public  Espresso(){
        desc = "Espresso";
    }

    public double cost(){
        return 1.99;
    }
}

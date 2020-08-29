package com.lyh.personal.demo.design.decorator.coffees;

import com.lyh.personal.demo.design.decorator.compoent.coffee.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast(){
        desc = "Dark Roast Coffee";
    }

    public double cost(){
        return .99;
    }

}

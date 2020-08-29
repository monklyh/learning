package com.lyh.personal.demo.design.decorator.coffees;

import com.lyh.personal.demo.design.decorator.compoent.coffee.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend(){
        desc = "House Blend Coffee";
    }

    public double cost(){
        return .89;
    }

}

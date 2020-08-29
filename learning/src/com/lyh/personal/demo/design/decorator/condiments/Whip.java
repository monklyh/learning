package com.lyh.personal.demo.design.decorator.condiments;

import com.lyh.personal.demo.design.decorator.compoent.coffee.Beverage;
import com.lyh.personal.demo.design.decorator.compoent.condiment.CondimentDecorator;


public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDesc(){
        return beverage.getDesc() + ", Whip";
    }

    public double cost(){
        return .10 + beverage.cost();
    }

}

package com.lyh.personal.demo.design.decorator.condiments;

import com.lyh.personal.demo.design.decorator.compoent.coffee.Beverage;
import com.lyh.personal.demo.design.decorator.compoent.condiment.CondimentDecorator;

public class Soy  extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDesc(){
        return beverage.getDesc() + ", Soy";
    }

    public double cost(){
        return .15 + beverage.cost();
    }

}

package com.lyh.personal.demo.design.decorator.condiments;

import com.lyh.personal.demo.design.decorator.compoent.coffee.Beverage;
import com.lyh.personal.demo.design.decorator.compoent.condiment.CondimentDecorator;

public class Moca extends CondimentDecorator {
    Beverage beverage;

    public Moca(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDesc(){
        return beverage.getDesc() + ", Moca";
    }

    public double cost(){
        return .20 + beverage.cost();
    }

}

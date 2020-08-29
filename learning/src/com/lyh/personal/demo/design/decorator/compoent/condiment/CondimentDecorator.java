package com.lyh.personal.demo.design.decorator.compoent.condiment;

import com.lyh.personal.demo.design.decorator.compoent.coffee.Beverage;

/**
 *  基础调料装饰者
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract  String getDesc();
}

package com.lyh.personal.demo.design.decorator.compoent.coffee;

/**
 *  ���࣬����һ�㡣
 */
public  abstract  class Beverage  {

    public String desc = "Unknow Beverage";

    public String getDesc(){
        return desc;
    }

    public abstract  double cost();

}

package com.lyh.personal.demo.design.factory.abstractFuction.store;

import com.lyh.personal.demo.design.factory.abstractFuction.pizza.Pizza;

public abstract  class PizzaStore {


    public Pizza orderPizza(String type){
        Pizza pizza ;
        pizza = createPizza(type);
        pizza.dealIt();
        return  pizza;
    }

    abstract  Pizza createPizza(String type);

}

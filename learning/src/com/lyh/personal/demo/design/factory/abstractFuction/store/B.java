package com.lyh.personal.demo.design.factory.abstractFuction.store;

import com.lyh.personal.demo.design.factory.abstractFuction.pizza.B1P;
import com.lyh.personal.demo.design.factory.abstractFuction.pizza.B2P;
import com.lyh.personal.demo.design.factory.abstractFuction.pizza.Pizza;

public class B extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        if ("B1".equals(type)){
            return new B1P();
        }else if ("B2".equals(type)){
            return new B2P();
        }
        return null;
    }
}

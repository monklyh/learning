package com.lyh.personal.demo.design.factory.abstractFuction.store;

import com.lyh.personal.demo.design.factory.abstractFuction.pizza.*;

public class A extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        if ("A1".equals(type)){
            return new A1P();
        }else if ("A2".equals(type)){
            return new A2P();
        }
        return null;
    }
}

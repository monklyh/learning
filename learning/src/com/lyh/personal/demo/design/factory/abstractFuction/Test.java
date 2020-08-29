package com.lyh.personal.demo.design.factory.abstractFuction;

import com.lyh.personal.demo.design.factory.abstractFuction.pizza.Pizza;
import com.lyh.personal.demo.design.factory.abstractFuction.store.A;
import com.lyh.personal.demo.design.factory.abstractFuction.store.B;
import com.lyh.personal.demo.design.factory.abstractFuction.store.PizzaStore;

public class Test {

    public  static  void main(String[] args){
        PizzaStore a = new A();
        PizzaStore b = new B();

        Pizza p = a.orderPizza("A1");
        System.out.println(p.getName());

        p = b.orderPizza("B2");
        System.out.println(p.getName());

    }

}

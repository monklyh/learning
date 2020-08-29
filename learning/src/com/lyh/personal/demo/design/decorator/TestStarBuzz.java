package com.lyh.personal.demo.design.decorator;

import com.lyh.personal.demo.design.decorator.coffees.DarkRoast;
import com.lyh.personal.demo.design.decorator.coffees.Espresso;
import com.lyh.personal.demo.design.decorator.coffees.HouseBlend;
import com.lyh.personal.demo.design.decorator.compoent.coffee.Beverage;
import com.lyh.personal.demo.design.decorator.condiments.Moca;
import com.lyh.personal.demo.design.decorator.condiments.Soy;
import com.lyh.personal.demo.design.decorator.condiments.Whip;

public class TestStarBuzz {

    public static void main(String[] arg){
        Beverage b = new Espresso();
        System.out.println(b.getDesc() + " $" + b.cost());
        Beverage b2 = new DarkRoast();
        b2 = new Moca(b2);
        b2 = new Soy(b2);
        b2 = new Whip(b2);
        System.out.println(b2.getDesc() + " $" + b2.cost());
        Beverage b3 = new HouseBlend();
        b3 = new Soy(b3);
        b3 = new Moca(b3);
        b3 = new Whip(b3);
        System.out.println(b3.getDesc() + " $" + b3.cost());

    }

}

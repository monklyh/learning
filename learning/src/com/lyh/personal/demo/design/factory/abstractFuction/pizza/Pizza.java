package com.lyh.personal.demo.design.factory.abstractFuction.pizza;

public abstract class Pizza  {

    public String name = "P";

    public void dealIt(){
        System.out.println("make pizza!");
    }

    public  String getName(){
        return name;
    }

}

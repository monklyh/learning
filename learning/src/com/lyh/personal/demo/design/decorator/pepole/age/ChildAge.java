package com.lyh.personal.demo.design.decorator.pepole.age;

import com.lyh.personal.demo.design.decorator.pepole.Body;

public class ChildAge extends Age4Body {

    Body body;

    public ChildAge(Body body){
        this.body = body;
    }

    @Override
    public Body growUp() {
        System.out.println("when growing up " + this.getAge() + " , to be a child");
        return this;
    }

    @Override
    public int getAge(){
       return body.getAge() + 6;
    }
}

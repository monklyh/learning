package com.lyh.personal.demo.design.decorator.pepole.age;

import com.lyh.personal.demo.design.decorator.pepole.Body;

public class YongAge extends Age4Body {

   public Body body;

    public YongAge(Body body){
        this.body = body;
    }

    @Override
    public Body growUp() {
        System.out.println("when growing up " + this.getAge() + " , to be an yong pepole");
        return this;
    }

    @Override
    public int getAge(){
        return body.getAge() + 15;
    }
}

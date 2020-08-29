package com.lyh.personal.demo.design.decorator.pepole.cloth;

import com.lyh.personal.demo.design.decorator.pepole.Body;

public class TShirt extends Clothes4Body {


    @Override
    public Body wear(Body body){
        System.out.println(body.showTheBody += "\r\nwearing a t-shirt");
        return body;
    }


}

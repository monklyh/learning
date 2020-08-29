package com.lyh.personal.demo.design.decorator.pepole;

import com.lyh.personal.demo.design.decorator.pepole.age.ChildAge;
import com.lyh.personal.demo.design.decorator.pepole.age.YongAge;
import com.lyh.personal.demo.design.decorator.pepole.cloth.Sock;
import com.lyh.personal.demo.design.decorator.pepole.cloth.TShirt;

public class BodyTest {

    public static  void main(String[] args){
        Body b1 = new Body();
        // 以下是不修改起始b1实例内容的实现方式
        b1 = new ChildAge(b1).growUp();
        b1 = new YongAge(b1).growUp();

        // 以下是修改起始b1实例内容的实现方式
        b1 = new Sock().wear(b1);
        b1 = new TShirt().wear(b1);

    }
}

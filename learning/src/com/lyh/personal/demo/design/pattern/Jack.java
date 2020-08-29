package com.lyh.personal.demo.design.pattern;

public class Jack extends Character {

    public Jack(String name, String face, String sex) {
        super(name, face, sex);
        getEquipment().setWaepon(new Sword());
        setDressUP(new Crown());
    }

    @Override
    public void desc(){
        System.out.println("prince Jack");
    }

}

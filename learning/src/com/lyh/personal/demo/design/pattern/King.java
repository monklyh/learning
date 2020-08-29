package com.lyh.personal.demo.design.pattern;

public class King  extends Character {

    public King(String name, String face, String sex) {
        super(name, face, sex);
        getEquipment().setWaepon(new Truncheon());
        setDressUP(new Crown());
    }

    @Override
    public void desc(){
        System.out.println("king");
    }

}
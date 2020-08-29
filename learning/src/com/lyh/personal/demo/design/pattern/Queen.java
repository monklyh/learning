package com.lyh.personal.demo.design.pattern;

public class Queen extends  Character {

    public Queen(String name, String face, String sex) {
        super(name, face, sex);
        getEquipment().setWaepon(new Wand());
        setDressUP(new Crown());
    }

    @Override
    public void desc(){
        System.out.println("queen");
    }

}

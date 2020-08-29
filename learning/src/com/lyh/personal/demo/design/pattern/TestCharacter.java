package com.lyh.personal.demo.design.pattern;

public class TestCharacter {
    public static void main(String[] args){
        Character king = new King("old king LB","old face","old man");
        Character queen = new Queen("old queen Alice","heavy makeup","old women");
        Character jack = new Jack("jack","yong face","young man");
        System.out.println("---------------------------------------");
        king.display();
        System.out.println("---------------------------------------");
        queen.display();
        System.out.println("---------------------------------------");
        jack.display();
        System.out.println("-------------@@@@@@@@@@@@@--------------");
        // Ωªªª¡ÀŒ‰∆˜
        Weapon tempW = jack.getEquipment().getWaepon();
        jack.getEquipment().setWaepon(king.getEquipment().getWaepon());
        king.getEquipment().setWaepon(tempW);
        System.out.println("---------------------------------------");
        jack.display();
        System.out.println("---------------------------------------");
        king.display();
        System.out.println("---------------------------------------");

    }
}

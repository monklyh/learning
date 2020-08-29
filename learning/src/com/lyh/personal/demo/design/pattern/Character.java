package com.lyh.personal.demo.design.pattern;

public class Character {
    private String name = "";
    private String face = "";
    private String sex = "";
    private DressUP dressUP;
    private Equipment equipment;

    public Character(String name, String face, String sex){
        equipment = new Equipment();
        this.name = name;
        this.face = face;
        this.sex = sex;
    }

    public  void desc(){
        System.out.println("³õÊ¼½ÇÉ«");
    }

    public void display(){
        desc();
        System.out.println("name: " + this.name);
        System.out.println("face: " + this.face);
        System.out.println("sex: " + this.sex);
        System.out.println("dressUP: " + this.dressUP.playerShow());
        this.equipment.showEquiment();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public DressUP getDressUP() {
        return dressUP;
    }

    public void setDressUP(DressUP dressUP) {
        this.dressUP = dressUP;
    }

    public Equipment getEquipment() {
        return equipment;
    }

//    public void setEquipment(Equipment equipment) {
//        this.equipment = equipment;
//    }
}


class Equipment{
    Weapon waepon;
    public void showWeapon(){
        waepon.weaponShow();
    }

    public Weapon getWaepon() {
        return waepon;
    }

    public void setWaepon(Weapon waepon) {
        this.waepon = waepon;
    }

    public void showEquiment(){
        System.out.println("waepon :" + waepon.weaponShow());
    }
    //    Clolthes clothes;
//    Shoes shoes;
//    Pants pants;
}
package com.lyh.personal.p1;

public class TestEnme {

    public static  void main(String[] args){
        // ����ö���÷���������ö����ӳ��һ�Թ�ϵ
        int code  = Codes.valueOf("Name").code;
        System.out.println("get code integer:"+code);
        System.out.println("F Str : " + F.valueOf("n").str);

    }

}

enum Codes {
    Name(0), Age(1), Address(2);

    public int code;
    Codes(int code){
            this.code = code;
    }
}

enum F{
    n("name"), m("my");
    public String str;

    F(String str){
        this.str=str;
    }


}
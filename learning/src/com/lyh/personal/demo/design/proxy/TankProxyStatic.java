package com.lyh.personal.demo.design.proxy;

/**
 * 静态代理方式
 * 代理 与 被代理类实现相同的接口
 * 代理只能为一个类服务，如果代理多个类，就需要创建多个代理
 */
public class TankProxyStatic implements Moveable {
    /** 被代理对象 */
    Moveable tank;

    public TankProxyStatic(Moveable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("driver has already...");
        tank.move();
        System.out.println("let's go ahead...");
    }

    public static void main(String[] args) {
        Moveable tank = new Tank();
        TankProxyStatic tankProxyStatic = new TankProxyStatic(tank);
        tankProxyStatic.move();
    }
}

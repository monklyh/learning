package com.lyh.personal.demo.design.proxy.dynamic;

import com.lyh.personal.demo.design.proxy.Moveable;
import com.lyh.personal.demo.design.proxy.Tank;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk �ṩ�Ķ�̬������ƣ�ʹ�÷������ʵ�֣���̬���ɴ�����ֽ����ļ����ٽ���������class���ڴ棩
 * �ο������https://www.jianshu.com/p/9bcac608c714
 * ����˵����Ҫί�д���ִ�е��߼���
 * ��Ҫ��һ��ʵ����InvocationHandler�ӿڵ�����ʵ�֣�
 * ���handler������ɴ���ʵ����ʱ��
 * ��������Ҫ�����ʵ��һ���ӿڣ����ɵĴ���ʵ��ֻ�ܵ��ýӿڵķ�������
 * ���ɵĴ����У�������д�Ľӿڷ������ᱻ����ί��ִ�е��߼���
 */
public class JdkProxyHandler implements InvocationHandler {

    private Object o;
    public JdkProxyHandler(Object o){
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke " + method.getName() + " ...");
        method.invoke(o, args);
        System.out.println("after invoke " + method.getName() + " ...");
        return null;
    }

    public static void main(String[] args) {
        Moveable tank = new Tank();
        JdkProxyHandler tankProxyHandler = new JdkProxyHandler(tank);
        Moveable tankProxy = (Moveable) Proxy.newProxyInstance(tank.getClass().getClassLoader(),
                tank.getClass().getInterfaces(), tankProxyHandler);
        tankProxy.move();

        Call call = new Caller();
        JdkProxyHandler callerHandler = new JdkProxyHandler(call);
        Call callProxy = (Call) Proxy.newProxyInstance(call.getClass().getClassLoader(),
                call.getClass().getInterfaces(), callerHandler);
        callProxy.call();
        callProxy.recviced("tank copied...");
    }

}

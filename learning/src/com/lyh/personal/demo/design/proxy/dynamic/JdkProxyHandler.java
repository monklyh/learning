package com.lyh.personal.demo.design.proxy.dynamic;

import com.lyh.personal.demo.design.proxy.Moveable;
import com.lyh.personal.demo.design.proxy.Tank;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 提供的动态代理机制（使用反射机制实现，动态生成代理的字节码文件，再解析它生成class到内存）
 * 参考解读：https://www.jianshu.com/p/9bcac608c714
 * 简单来说：需要委托代理执行的逻辑，
 * 需要用一个实现了InvocationHandler接口的类来实现；
 * 这个handler类的生成代理实例的时候，
 * 被代理类要求必需实现一个接口（生成的代理实例只能调该接口的方法），
 * 生成的代理中，所有重写的接口方法都会被加入委托执行的逻辑；
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
        // 保存生成的代理类，例如：$Proxy1.class
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Moveable tank = new Tank();
        JdkProxyHandler tankProxyHandler = new JdkProxyHandler(tank);
        Moveable tankProxy = (Moveable) Proxy.newProxyInstance(tank.getClass().getClassLoader(),
                tank.getClass().getInterfaces(), tankProxyHandler);
        tankProxy.move();
        System.out.println("tankProxy=" + tankProxy);

        Call call = new Caller();
        JdkProxyHandler callerHandler = new JdkProxyHandler(call);
        Call callProxy = (Call) Proxy.newProxyInstance(call.getClass().getClassLoader(),
                call.getClass().getInterfaces(), callerHandler);
        callProxy.call();
        callProxy.recviced("tank copied...");
        System.out.println("callProxy=" + callProxy);
    }

}

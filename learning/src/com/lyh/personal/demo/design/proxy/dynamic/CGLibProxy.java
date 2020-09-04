package com.lyh.personal.demo.design.proxy.dynamic;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib 是第三方类库工具，它动态生成一个被代理类的子类，
 * 子类重写被代理的类的所有不是final的方法。
 * 在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。
 */
public class CGLibProxy {

    public static void main(String[] args) {
        // 保存生成的代理类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "learning/src/com/lyh/personal/demo/design/proxy/dynamic/cgligClass");
        Enhancer enhancer = new Enhancer();
        //继承被代理类
        enhancer.setSuperclass(Caller.class);
        //设置回调，使用拦截器：实现MethodInterceptor接口生成方法拦截器
        enhancer.setCallback(new MethodInterceptor(){
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("-Before invoke: "  + method.getName());
                Object object = methodProxy.invokeSuper(o, objects);
                System.out.println("-After invoke: " + method.getName());
                return object;
            }
        });
        //设置代理类对象
        Caller callerProxy = (Caller) enhancer.create();
        //在调用代理类中方法时会被我们实现的方法拦截器进行拦截
        callerProxy.call();
        callerProxy.recviced("the message has copied...");
    }

}

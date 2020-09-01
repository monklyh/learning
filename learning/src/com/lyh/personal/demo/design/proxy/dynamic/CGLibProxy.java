package com.lyh.personal.demo.design.proxy.dynamic;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib �ǵ�������⹤�ߣ�����̬����һ��������������࣬
 * ������д�������������в���final�ķ�����
 * �������в��÷������صļ����������и��෽���ĵ��ã�˳��֯������߼���
 */
public class CGLibProxy {

    public static void main(String[] args) {
        // �������ɵĴ�����
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "learning/src/com/lyh/personal/demo/design/proxy/dynamic/cgligClass");
        Enhancer enhancer = new Enhancer();
        //�̳б�������
        enhancer.setSuperclass(Caller.class);
        //���ûص���ʹ����������ʵ��MethodInterceptor�ӿ����ɷ���������
        enhancer.setCallback(new MethodInterceptor(){
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("-Before invoke: "  + method.getName());
                Object object = methodProxy.invokeSuper(o, objects);
                System.out.println("-After invoke: " + method.getName());
                return object;
            }
        });
        //���ô��������
        Caller callerProxy = (Caller) enhancer.create();
        //�ڵ��ô������з���ʱ�ᱻ����ʵ�ֵķ�����������������
        callerProxy.call();
        callerProxy.recviced("the message has copied...");
    }

}

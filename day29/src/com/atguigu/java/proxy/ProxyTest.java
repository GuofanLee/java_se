package com.atguigu.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author GuofanLee
 * @date 2019-04-28 13:29
 */
public class ProxyTest {

    public static void main(String[] args) {
        //被代理类对象
        SuperMan superMan = new SuperMan();
        //代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("麻辣烫");
    }

}

class ProxyFactory {

    /**
     * 生成代理类对象
     * @param obj 被代理类对象
     * @return 代理类对象
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        invocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    /**
     * 被代理类对象
     */
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    /**
     * 代理类对象的invoke方法
     *
     * @param proxy 代理类对象
     * @param method 要调用的方法
     * @param args 方法参数
     * @return 方法返回值
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用被代理对象的同名方法
        return method.invoke(obj, args);
    }
}

interface Human {
    String getBelief();
    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I belief I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}
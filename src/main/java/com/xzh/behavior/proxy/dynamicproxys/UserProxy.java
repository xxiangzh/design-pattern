package com.xzh.behavior.proxy.dynamicproxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 向振华
 * @date 2018/11/20 14:24
 */
public class UserProxy<T> implements InvocationHandler {

    //被代理的对象
    private T target;

    //将需要代理的实例通过处理器类的构造方法传递给代理
    public UserProxy(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理s前");
        Object invoke = method.invoke(target, args);
        System.out.println("动态代理s后");
        return invoke;
    }
}

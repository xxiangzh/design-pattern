package com.xzh.behavior.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  创建动态代理对象
 *  动态代理不需要实现接口,但是需要指定接口类型
 * @author 向振华
 * @date 2018/11/19 10:30
 */
public class ProxyFactory{

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target=target;
    }

    /**
     * 给目标对象生成代理对象
     * @return
     */
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
                target.getClass().getInterfaces(),//Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
                new InvocationHandler() {//InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("dynamicproxy开始事务");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("dynamicproxy提交事务");
                        return returnValue;
                    }
                }
        );
    }

}

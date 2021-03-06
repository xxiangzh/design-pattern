package com.xzh.behavior.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib子类代理工厂
 *  对UserDao在内存中动态构建一个子类对象
 * @author 向振华
 * @date 2018/11/19 10:42
 */
public class ProxyFactory implements MethodInterceptor {

    //维护目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(this.target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglibproxy开始事务...");
        //目标对象的方法
//        Object o = proxy.invokeSuper(obj, args);
        Object o = method.invoke(target, args);
        System.out.println("cglibproxy提交事务...");
        return o;
    }
}


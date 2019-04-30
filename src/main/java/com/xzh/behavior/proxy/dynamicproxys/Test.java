package com.xzh.behavior.proxy.dynamicproxys;

import com.xzh.behavior.proxy.service.UserService;
import com.xzh.behavior.proxy.service.impl.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author 向振华
 * @date 2018/11/20 14:31
 */
public class Test {
    public static void main(String[] args) {

        //创建一个实例对象，这个对象是被代理的对象
        UserService userService = new UserServiceImpl();

        //创建一个与代理对象相关联的InvocationHandler
        UserProxy userProxy = new UserProxy<>(userService);

        //创建一个代理对象stateServiceProxy来代理stateService，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class<?>[]{UserService.class}, userProxy);

        //代理对象执行方法
        userServiceProxy.save();
    }
}

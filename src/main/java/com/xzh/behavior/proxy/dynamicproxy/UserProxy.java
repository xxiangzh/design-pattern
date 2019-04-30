package com.xzh.behavior.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用户代理
 *
 * @author 向振华
 * @date 2019/04/30 10:23
 */
public class UserProxy{
    //接收保存目标对象
    private UserService userServiceImpl;

    public UserProxy(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    //给目标对象生成代理对象
    public UserService getProxyInstance(){
        return (UserService)Proxy.newProxyInstance(
                userServiceImpl.getClass().getClassLoader(),
                userServiceImpl.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("存前...");
                        Object invoke = method.invoke(userServiceImpl, args);
                        System.out.println("存后...");
                        return invoke;
                    }
                }
        );
    }
}

package com.xzh.behavior.proxy.staticproxy;

import com.xzh.behavior.proxy.service.impl.UserServiceImpl;

/**
 * @author 向振华
 * @date 2019/04/30 10:27
 */
public class Test {
    public static void main(String[] args) {
        //代理对象,把目标对象传给代理对象,建立代理关系
        UserProxy userProxy = new UserProxy(new UserServiceImpl());
        //执行代理的方法
        userProxy.save();
    }
}

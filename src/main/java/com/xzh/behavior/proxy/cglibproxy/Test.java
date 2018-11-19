package com.xzh.behavior.proxy.cglibproxy;

/**
 * @author 向振华
 * @date 2018/11/19 10:44
 */
public class Test {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}

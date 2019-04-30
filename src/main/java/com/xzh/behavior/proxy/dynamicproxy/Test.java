package com.xzh.behavior.proxy.dynamicproxy;

/**
 * @author 向振华
 * @date 2019/04/30 10:47
 */
public class Test {
    public static void main(String[] args) {
        UserProxy userProxy = new UserProxy(new UserServiceImpl());
        UserService userService = userProxy.getProxyInstance();
        userService.save();
    }
}

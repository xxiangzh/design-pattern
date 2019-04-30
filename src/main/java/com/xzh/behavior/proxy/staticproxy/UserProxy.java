package com.xzh.behavior.proxy.staticproxy;

import com.xzh.behavior.proxy.service.UserService;

/**
 * 用户代理
 *
 * @author 向振华
 * @date 2019/04/30 10:23
 */
public class UserProxy implements UserService {
    //接收保存目标对象
    private UserService userServiceImpl;

    public UserProxy(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void save() {
        System.out.println("静态代理前...");
        userServiceImpl.save();
        System.out.println("静态代理后...");
    }
}

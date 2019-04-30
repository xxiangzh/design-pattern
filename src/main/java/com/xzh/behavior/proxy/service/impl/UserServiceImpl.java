package com.xzh.behavior.proxy.service.impl;

import com.xzh.behavior.proxy.service.UserService;

/**
 * 用户实现类
 *
 * @author 向振华
 * @date 2019/04/30 10:22
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("----保存----");
    }
}

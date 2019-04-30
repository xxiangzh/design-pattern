package com.xzh.behavior.proxy.dynamicproxy;

/**
 * 用户实现类
 *
 * @author 向振华
 * @date 2019/04/30 10:22
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("----dynamicproxy已经保存数据!----");
    }
}

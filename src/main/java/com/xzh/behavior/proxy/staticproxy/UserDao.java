package com.xzh.behavior.proxy.staticproxy;

/**
 * 接口实现
 * 目标对象
 * @author 向振华
 * @date 2018/11/19 10:14
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----staticproxy已经保存数据!----");
    }
}

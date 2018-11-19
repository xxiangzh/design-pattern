package com.xzh.behavior.proxy.cglibproxy;

/**
 * 目标对象,没有实现任何接口
 * @author 向振华
 * @date 2018/11/19 10:14
 */
public class UserDao{
    public void save() {
        System.out.println("----cglibproxy已经保存数据!----");
    }
}

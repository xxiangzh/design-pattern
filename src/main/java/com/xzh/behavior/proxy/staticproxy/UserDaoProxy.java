package com.xzh.behavior.proxy.staticproxy;

/**
 * 代理对象,静态代理
 * @author 向振华
 * @date 2018/11/19 10:15
 */
public class UserDaoProxy implements IUserDao{

    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    @Override
    public void save() {
        System.out.println("staticproxy开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("staticproxy提交事务...");
    }
}

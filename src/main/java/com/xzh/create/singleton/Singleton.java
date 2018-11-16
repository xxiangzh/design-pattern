package com.xzh.create.singleton;

/**
 * 安全的单例模式
 * @author 向振华
 * @date 2018/11/16 11:41
 */
public class Singleton {

    //静态的内部类创建实例
    private static class SingletonInstance{
        static Singleton instance = new Singleton();
    }

    //私有化构造函数
    private Singleton(){
    }

    //给出一个公共的静态方法返回一个单一实例
    public static Singleton getInstance(){
        return SingletonInstance.instance;
    }
}

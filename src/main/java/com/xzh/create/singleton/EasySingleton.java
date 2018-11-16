package com.xzh.create;

/**
 * 简单单例模式
 * 在并发环境下会出现多个实例
 * @author 向振华
 * @date 2018/11/16 10:53
 */
public class EasySingleton {

    //一个静态的实例
    private static EasySingleton easySingleton;

    //私有化构造函数
    private EasySingleton(){
    }

    //给出一个公共的静态方法返回一个单一实例
    public static EasySingleton getInstance(){
        if (easySingleton == null) {
            easySingleton = new EasySingleton();
        }
        return easySingleton;
    }
}

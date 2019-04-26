package com.xzh.create.singleton;

/**
 * 双重加锁单例模式
 * 在有些JVM会出问题，JVM会针对字节码进行调优，可能调整指令的执行顺序。
 * 如果先将内存地址赋给对象，针对上述的双重加锁，就是说先将分配好的内存地址指给synchronizedSingleton，
 * 然后再进行初始化构造器，这时候后面的线程去请求getInstance方法时，会认为synchronizedSingleton对象已经实例化了，
 * 直接返回一个引用。如果在初始化构造器之前，这个线程使用了synchronizedSingleton，就会产生莫名的错误。
 * @author 向振华
 * @date 2018/11/16 11:20
 */
public class SynchronizedSingleton {

    //一个静态的实例
    private static SynchronizedSingleton synchronizedSingleton;

    //私有化构造函数
    private SynchronizedSingleton() {
    }

    //给出一个公共的静态方法返回一个单一实例
    public static SynchronizedSingleton getInstance(){
        if (synchronizedSingleton == null) {
            synchronized (SynchronizedSingleton.class) {
                if (synchronizedSingleton == null){
                    synchronizedSingleton = new SynchronizedSingleton();
                }
            }
        }
        return synchronizedSingleton;
    }
}

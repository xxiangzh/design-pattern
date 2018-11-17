package com.xzh.structure.templatemethod.loadclass;

/**
 * @author 向振华
 * @date 2018/11/17 15:51
 */
public abstract class ClassLoader {

    //这是一个重载方法
    public Class<?> loadClass(String name) {
        return loadClass(name, false);
    }

    //这里就是父类算法的定义
    protected synchronized Class<?> loadClass(String name, boolean resolve) {
        Class c = findLoadedClass(name);
        if (c == null) {
            if (parent != null) {
                c = parent.loadClass(name, false);
            } else {
                c = findBootstrapClass0(name);
            }
        }
        if (resolve) {
            resolveClass(c);
        }
        return c;
    }

    //这里留了一个方法给子类选择性覆盖
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }





    //为了不报错写的
    abstract Class findLoadedClass(String name);
    abstract Class findBootstrapClass0(String name);
    abstract void resolveClass(Class c);
    class Parent {private Object object;
        Class loadClass(String name, boolean b) {
            return null;
        }
    };
    private Parent parent;
}

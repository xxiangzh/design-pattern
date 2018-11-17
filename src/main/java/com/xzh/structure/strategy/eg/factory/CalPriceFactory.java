package com.xzh.structure.strategy.eg.factory;

import com.xzh.structure.strategy.eg.customer.Customer;
import com.xzh.structure.strategy.eg.annotation.TotalValidRegion;
import com.xzh.structure.strategy.eg.calculate.CalPrice;
import com.xzh.structure.strategy.eg.utils.ClassUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 向振华
 * @date 2018/11/16 15:44
 */
public class CalPriceFactory {

    //这里是一个常量，表示我们扫描策略的包，这是的包名
    private static final String CAL_PRICE_PACKAGE = "com.xzh.structure.strategy.eg.calculate.impl";

    //我们加载策略时的类加载器，我们任何类运行时信息必须来自该类加载器
    private static final ClassLoader CLASS_LOADER = CalPriceFactory.class.getClassLoader();

    //策略列表
    private static final List<Class<? extends CalPrice>> CAL_PRICE_LIST = new ArrayList<Class<? extends CalPrice>>();

    //根据客户的总金额产生相应的策略
    public CalPrice createCalPrice(Customer customer){
        //在策略列表查找策略
        for (Class<? extends CalPrice> clazz : CAL_PRICE_LIST) {
            //获取该策略的注解
            TotalValidRegion validRegion = handleAnnotation(clazz);
            if (validRegion == null){
                continue;
            }
            //判断金额是否在注解的区间
            if (customer.getTotalAmount() > validRegion.min() && customer.getTotalAmount() < validRegion.max()) {
                try {
                    //是的话我们返回一个当前策略的实例
                    return clazz.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("策略获得失败!");
                }
            }
        }
        throw new RuntimeException("策略获得失败!!");
    }

    //处理注解，我们传入一个类，返回它的注解
    private TotalValidRegion handleAnnotation(Class<? extends CalPrice> clazz){
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (Annotation annotation : annotations) {
            if (annotation instanceof TotalValidRegion) {
                return (TotalValidRegion) annotation;
            }
        }
        return null;
    }


    //获取实例（单例）
    public static CalPriceFactory getInstance(){
        return CalPriceFactoryInstance.instance;
    }

    private static class CalPriceFactoryInstance{
        private static CalPriceFactory instance = new CalPriceFactory();
    }

    private CalPriceFactory(){
        init();
    }

    //在工厂初始化时要初始化策略列表
    private void init(){
        //获取到包下所有的class文件
        File[] resources = ClassUtils.getResources(CAL_PRICE_PACKAGE);
        if(resources == null || resources.length == 0){
            return;
        }
        for (File resource : resources) {
            try {
                //载入包下的类
                Class<?> clazz = CLASS_LOADER.loadClass(CAL_PRICE_PACKAGE + "." + resource.getName().replace(".class", ""));
                //判断是否是CalPrice的实现类，满足的话加入到策略列表
                if (CalPrice.class.isAssignableFrom(clazz)) {
                    CAL_PRICE_LIST.add((Class<? extends CalPrice>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
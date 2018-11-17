package com.xzh.structure.strategy.egs.factory;

import com.xzh.structure.strategy.egs.annotation.OnceValidRegion;
import com.xzh.structure.strategy.egs.annotation.TotalValidRegion;
import com.xzh.structure.strategy.egs.calculate.CalPrice;
import com.xzh.structure.strategy.egs.customer.Customer;
import com.xzh.structure.strategy.egs.proxy.CalPriceProxy;
import com.xzh.structure.strategy.egs.utils.ClassUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author 向振华
 * @date 2018/11/16 15:44
 */
public class CalPriceFactory {

    //这里是一个常量，表示我们扫描策略的包，这是的包名
    private static final String CAL_PRICE_PACKAGE = "com.xzh.structure.strategy.egs.calculate.impl";

    //我们加载策略时的类加载器，我们任何类运行时信息必须来自该类加载器
    private static final ClassLoader CLASS_LOADER = CalPriceFactory.class.getClassLoader();

    //策略列表
    private static final List<Class<? extends CalPrice>> CAL_PRICE_LIST = new ArrayList<Class<? extends CalPrice>>();

    //根据客户的总金额产生相应的策略
    public CalPrice createCalPrice(Customer customer){
        //变化点:为了支持优先级排序，我们采用可排序的MAP支持,这个Map是为了储存我们当前策略的运行时类信息
        SortedMap<Integer, Class<? extends CalPrice>> clazzMap = new TreeMap<Integer, Class<? extends CalPrice>>();
        //在策略列表查找策略
        for (Class<? extends CalPrice> clazz : CAL_PRICE_LIST) {
            Annotation validRegion = handleAnnotation(clazz);//获取该策略的注解
            //变化点：根据注解类型进行不同的判断
            if (validRegion instanceof TotalValidRegion) {
                TotalValidRegion totalValidRegion = (TotalValidRegion) validRegion;
                //判断总金额是否在注解的区间
                if (customer.getTotalAmount() > totalValidRegion.value().min() && customer.getTotalAmount() < totalValidRegion.value().max()) {
                    clazzMap.put(totalValidRegion.value().order(), clazz);//将采用的策略放入MAP
                }
            }
            else if (validRegion instanceof OnceValidRegion) {
                OnceValidRegion onceValidRegion = (OnceValidRegion) validRegion;
                //判断单次金额是否在注解的区间，注意这次判断的是客户当次消费的金额
                if (customer.getAmount() > onceValidRegion.value().min() && customer.getAmount() < onceValidRegion.value().max()) {
                    clazzMap.put(onceValidRegion.value().order(), clazz);//将采用的策略放入MAP
                }
            }
        }
        try {
            //我们采用动态代理处理策略重叠的问题，相信看过LZ的代理模式的同学应该都对代理模式的原理很熟悉了，那么下面出现的代理类LZ将不再解释，留给各位自己琢磨。
            return CalPriceProxy.getProxy(clazzMap);
        } catch (Exception e) {
            throw new RuntimeException("策略获得失败");
        }
    }

    //处理注解，我们传入一个策略类，返回它的注解
    private Annotation handleAnnotation(Class<? extends CalPrice> clazz){
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            //变化点：这里稍微改动了下,如果是TotalValidRegion,OnceValidRegion这两种注解则返回
            if (annotations[i] instanceof TotalValidRegion || annotations[i] instanceof OnceValidRegion) {
                return annotations[i];
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
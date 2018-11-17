package com.xzh.structure.strategy.egs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这是我们的总额有效区间注解，可以给策略添加有效区间的设置
 * @author 向振华
 * @date 2018/11/17 13:39
 */
@Target(ElementType.TYPE)//表示只能给类添加该注解
@Retention(RetentionPolicy.RUNTIME)//这个必须要将注解保留在运行时
public @interface TotalValidRegion {
    //我们引用有效区间注解
    ValidRegion value() default @ValidRegion;

}
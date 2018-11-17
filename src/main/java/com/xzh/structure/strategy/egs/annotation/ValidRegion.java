package com.xzh.structure.strategy.egs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 我们定义一个嵌套注解
 * @author 向振华
 * @date 2018/11/17 13:38
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRegion {
    int max() default Integer.MAX_VALUE;
    int min() default Integer.MIN_VALUE;

    //既然可以任意组合，我们就需要给策略定义下顺序，就比如刚才说的2000那个例子，按先返后打折的顺序是800，反过来就是600了。
    //所以我们必须支持这一特性，默认0，为最优先
    int order() default 0;
}
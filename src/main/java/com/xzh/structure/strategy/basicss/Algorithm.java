package com.xzh.structure.strategy.basicss;

import java.lang.annotation.*;

/**
 * @author 向振华
 * @date 2019/04/26 15:56
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Algorithm {
    int value();
}
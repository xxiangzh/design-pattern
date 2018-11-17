package com.xzh.structure.strategy.eg.calculate;

/**
 * @author 向振华
 * @date 2018/11/16 15:39
 */
public interface CalPrice {
    //根据原价返回一个最终的价格
    Double calPrice(Double originalPrice);
}

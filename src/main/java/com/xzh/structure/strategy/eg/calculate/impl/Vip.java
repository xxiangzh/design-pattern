package com.xzh.structure.strategy.eg.calculate.impl;

import com.xzh.structure.strategy.eg.annotation.TotalValidRegion;
import com.xzh.structure.strategy.eg.calculate.CalPrice;

/**
 * @author 向振华
 * @date 2018/11/16 15:41
 */
@TotalValidRegion(min=1000,max=2000)
public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }
}

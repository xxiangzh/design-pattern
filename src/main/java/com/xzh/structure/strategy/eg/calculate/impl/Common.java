package com.xzh.structure.strategy.eg.calculate.impl;

import com.xzh.structure.strategy.eg.annotation.TotalValidRegion;
import com.xzh.structure.strategy.eg.calculate.CalPrice;

/**
 * @author 向振华
 * @date 2018/11/16 15:41
 */
@TotalValidRegion(max=1000)//设置普通的在0-1000生效
public class Common implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }
}

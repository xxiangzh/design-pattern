package com.xzh.structure.strategy.egs.calculate.impl;

import com.xzh.structure.strategy.egs.annotation.TotalValidRegion;
import com.xzh.structure.strategy.egs.annotation.ValidRegion;
import com.xzh.structure.strategy.egs.calculate.CalPrice;

/**
 * @author 向振华
 * @date 2018/11/16 15:41
 */
@TotalValidRegion(@ValidRegion(min=1000,max=2000,order=99))
public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }
}

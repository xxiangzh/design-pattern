package com.xzh.structure.strategy.egs.calculate.impl;

import com.xzh.structure.strategy.egs.annotation.OnceValidRegion;
import com.xzh.structure.strategy.egs.annotation.ValidRegion;
import com.xzh.structure.strategy.egs.calculate.CalPrice;

/**
 *  满减200  (即满1000返200)
 * @author 向振华
 * @date 2018/11/17 13:44
 */
@OnceValidRegion(@ValidRegion(min=1000,max=2000,order=40))
public class FullReduction200 implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice - 200;
    }
}

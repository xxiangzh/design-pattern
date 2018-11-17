package com.xzh.structure.strategy.egs.calculate.impl;

import com.xzh.structure.strategy.egs.annotation.OnceValidRegion;
import com.xzh.structure.strategy.egs.annotation.ValidRegion;
import com.xzh.structure.strategy.egs.calculate.CalPrice;

/**
 * 满减300  (满2000返300)
 * @author 向振华
 * @date 2018/11/17 13:46
 */
@OnceValidRegion(@ValidRegion(min=2000,order=40))
public class FullReduction300 implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice - 300;
    }
}

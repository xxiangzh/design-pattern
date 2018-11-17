package com.xzh.structure.strategy.egs.calculate.impl;

import com.xzh.structure.strategy.egs.annotation.TotalValidRegion;
import com.xzh.structure.strategy.egs.annotation.ValidRegion;
import com.xzh.structure.strategy.egs.calculate.CalPrice;

/**
 * @author 向振华
 * @date 2018/11/16 15:41
 */
//我们使用嵌套注解，并且制定我们打折的各个策略顺序是99，这算是很靠后的
//因为我们最后打折算出来钱是最多的，这个一算就很清楚
@TotalValidRegion(@ValidRegion(max=1000,order=99))
public class Common implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }
}

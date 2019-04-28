package com.xzh.structure.strategy.basicss;

import org.springframework.stereotype.Component;

/**
 * @author 向振华
 * @date 2018/11/16 13:55
 */
@Algorithm(1)
@Component
public class StrategyA implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("采用策略A计算");
    }
}

package com.xzh.structure.strategy.basics;

import javax.annotation.Resource;

/**
 * @author 向振华
 * @date 2018/11/16 13:57
 */
public class Test {

    @Resource
    private StrategySelector strategySelector;

    public void test() {
        strategySelector.method(AlgorithmType.A.getType());
    }
}

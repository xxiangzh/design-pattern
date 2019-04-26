package com.xzh.structure.strategy.basic;

/**
 * @author 向振华
 * @date 2018/11/16 13:56
 */
public class StrategyContext {

    private Strategy strategy;

    public void method(){
        strategy.algorithm();
    }

    public StrategyContext() {
    }

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }
}

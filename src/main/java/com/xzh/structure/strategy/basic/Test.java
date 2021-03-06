package com.xzh.structure.strategy.basic;

/**
 * @author 向振华
 * @date 2018/11/16 13:57
 */
public class Test {

    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext(new StrategyA());
        strategyContext.method();
        Strategy strategy = StrategyFactory.getInstance().getStrategy(2);
        strategy.algorithm();
    }
}

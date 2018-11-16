package com.xzh.structure.strategy;

/**
 * @author 向振华
 * @date 2018/11/16 13:56
 */
public class ConcreteStrategyB implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("采用策略B计算");
    }
}

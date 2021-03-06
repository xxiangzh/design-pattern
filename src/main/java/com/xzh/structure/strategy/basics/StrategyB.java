package com.xzh.structure.strategy.basics;

import org.springframework.stereotype.Component;

/**
 * @author 向振华
 * @date 2018/11/16 13:56
 */
@Component
public class StrategyB implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("采用策略B计算");
    }

    @Override
    public Integer getAlgorithmType() {
        return AlgorithmType.B.getType();
    }
}

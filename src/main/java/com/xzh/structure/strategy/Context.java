package com.xzh.structure.strategy;

/**
 * @author 向振华
 * @date 2018/11/16 13:56
 */
public class Context {

    private Strategy strategy;

    public void method(){
        strategy.algorithm();
    }

    public Context() {
    }

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
}

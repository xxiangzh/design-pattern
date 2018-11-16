package com.xzh.structure.strategy;

/**
 * @author 向振华
 * @date 2018/11/16 13:57
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.method();
    }
}

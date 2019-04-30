package com.xzh.create.factory.abstractfactory;

/**
 * @author 向振华
 * @date 2019/04/29 16:45
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ProductFactory factory = new ProductFactory1();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();
        productA.methodA();
        productB.methodB();

        factory = new ProductFactory2();
        productA = factory.createProductA();
        productB = factory.createProductB();
        productA.methodA();
        productB.methodB();
    }
}

package com.xzh.create.factory.abstractfactory;

/**
 * @author 向振华
 * @date 2019/04/29 16:44
 */
public class ProductFactory2 implements ProductFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}

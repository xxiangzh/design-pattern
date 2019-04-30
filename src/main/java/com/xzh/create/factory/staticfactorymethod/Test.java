package com.xzh.create.factory.staticfactorymethod;

/**
 * @author 向振华
 * @date 2019/04/29 16:07
 */
public class Test {
    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("A");
        product.method();
    }
}

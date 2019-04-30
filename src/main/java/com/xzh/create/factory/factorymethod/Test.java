package com.xzh.create.factory.factorymethod;

import com.xzh.create.factory.staticfactorymethod.Product;

/**
 * @author 向振华
 * @date 2019/04/29 16:29
 */
public class Test {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductAFactory();
        Product product = productFactory.createProduct();
        product.method();
    }
}

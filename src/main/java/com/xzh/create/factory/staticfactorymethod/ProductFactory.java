package com.xzh.create.factory.staticfactorymethod;

/**
 * @author 向振华
 * @date 2019/04/29 16:03
 */
public class ProductFactory {

    public static Product createProduct(String productName){
        if (productName == null) {
            return null;
        }
        if (productName.equals("A")) {
            return new ProductA();
        }else if (productName.equals("B")) {
            return new ProductB();
        }else {
            return null;
        }
    }
}

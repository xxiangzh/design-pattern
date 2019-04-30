package com.xzh.create.factory.factorymethod;

import com.xzh.create.factory.staticfactorymethod.Product;
import com.xzh.create.factory.staticfactorymethod.ProductA;

/**
 * @author 向振华
 * @date 2019/04/29 16:03
 */
public class ProductAFactory implements ProductFactory{
    @Override
    public Product createProduct(){
        return new ProductA();
    }
}

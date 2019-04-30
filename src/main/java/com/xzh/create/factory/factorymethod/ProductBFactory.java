package com.xzh.create.factory.factorymethod;

import com.xzh.create.factory.staticfactorymethod.Product;
import com.xzh.create.factory.staticfactorymethod.ProductB;

/**
 * @author 向振华
 * @date 2019/04/29 16:03
 */
public class ProductBFactory implements ProductFactory{
    @Override
    public Product createProduct(){
        return new ProductB();
    }
}

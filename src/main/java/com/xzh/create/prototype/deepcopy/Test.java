package com.xzh.create.prototype.deepcopy;

/**
 * @author 向振华
 * @date 2018/11/17 15:20
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        Field field = new Field(1);
        DeepPrototype deepPrototype = new DeepPrototype("xx",field);
        System.out.println("原始数据"+deepPrototype);
        DeepPrototype clone = deepPrototype.clone();
        deepPrototype.setD("改变");
        field.setA(2);
        System.out.println("改变数据"+deepPrototype);
        System.out.println("克隆数据"+clone);
    }
}

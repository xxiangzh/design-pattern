package com.xzh.create.prototype.shallowcopy;

/**
 * @author 向振华
 * @date 2018/11/17 14:41
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        Num num = new Num(1,2);
        System.out.println("原始数据"+num);
        Num clonen = num.clone();
        num.setA(99);//改变
        num.setB(88);//改变
        System.out.println("改变数据"+num);
        System.out.println("克隆数据"+clonen);
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        User user = new User("xzh", 100);
        System.out.println("原始数据"+user);
        User clone = user.clone();
        user.setName("改变"); //改变
        user.setAge(222); //改变
        System.out.println("改变数据"+user);
        System.out.println("克隆数据"+clone);
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        ShallowPrototype shallowPrototype = new ShallowPrototype();
        shallowPrototype.setX("x");
        Prototype xxx = new Prototype("XXX");
        shallowPrototype.setPrototype(xxx);
        System.out.println("原始数据"+shallowPrototype);
        ShallowPrototype clones = shallowPrototype.clone();
        shallowPrototype.setX("改变"); //改变
        xxx.setP("zzz");//改变
        System.out.println("改变数据"+shallowPrototype);
        System.out.println("克隆数据"+clones);
        System.out.println("-------------------------------------");
    }
}

package com.xzh.structure.strategy.egs;

import com.xzh.structure.strategy.egs.customer.Customer;

/**
 * @author 向振华
 * @date 2018/11/16 15:51
 */
public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(9000.0);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
    }
}

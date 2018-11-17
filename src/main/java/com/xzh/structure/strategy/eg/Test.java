package com.xzh.structure.strategy.eg;

import com.xzh.structure.strategy.eg.customer.Customer;

/**
 * @author 向振华
 * @date 2018/11/16 15:51
 */
public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(9000.0);
        System.out.println("需支付："+customer.calLastAmount());
    }
}

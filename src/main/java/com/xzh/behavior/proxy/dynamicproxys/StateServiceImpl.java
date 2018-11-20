package com.xzh.behavior.proxy.dynamicproxys;

/**
 * @author 向振华
 * @date 2018/11/20 14:22
 */
public class StateServiceImpl implements StateService {
    @Override
    public void updateState() {
        System.out.println("状态修改辣！！！");
    }
}

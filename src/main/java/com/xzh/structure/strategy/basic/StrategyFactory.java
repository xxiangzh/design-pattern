package com.xzh.structure.strategy.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 向振华
 * @date 2019/04/26 11:41
 */
public class StrategyFactory {

    private static final StrategyFactory instance = new StrategyFactory();

    private StrategyFactory() {
    }

    public static StrategyFactory getInstance(){
        return instance;
    }

    private static Map<Integer,Strategy> map = new HashMap<>();

    public Strategy getStrategy(Integer type){
        if (type == null || !map.containsKey(type)){
            throw new RuntimeException("策略不存在！");
        }
        return map.get(type);
    }

    static {
        map.put(1,new ConcreteStrategyA());
        map.put(2,new ConcreteStrategyB());
    }
}

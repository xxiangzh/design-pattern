package com.xzh.structure.strategy.basics;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 向振华
 * @date 2019/04/26 14:01
 */
@Component
public class StrategySelector {
    private static Map<Integer,Strategy> map = new HashMap<>();

    @Autowired(required = false)
    private void  init(List<Strategy> strategies){
        if (CollectionUtils.isEmpty(strategies)) {
            return;
        }
        map = strategies.stream().collect(Collectors.toMap(Strategy::getAlgorithmType, s -> s));
        System.out.println("StrategyMap:"+JSON.toJSONString(map));
    }

    public void method(Integer type){
        map.get(type).algorithm();
    }
}

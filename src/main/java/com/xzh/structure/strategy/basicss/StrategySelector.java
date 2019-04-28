package com.xzh.structure.strategy.basicss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 向振华
 * @date 2019/04/26 14:01
 */
@Component
public class StrategySelector {
    private static Map<Integer, Strategy> map = new HashMap<>();

    @Autowired(required = false)
    private void  init(List<Strategy> strategies) {
        if (CollectionUtils.isEmpty(strategies)) {
            return;
        }
        for (Strategy strategy : strategies) {
            Algorithm annotation = AnnotationUtils.findAnnotation(strategy.getClass(), Algorithm.class);
            if(annotation == null){
                continue;
            }
            map.put(annotation.value(), strategy);
        }
    }

    public void method(Integer type){
        map.get(type).algorithm();
    }
}

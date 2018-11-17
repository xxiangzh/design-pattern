package com.xzh.create.prototype.shallowcopy;

import lombok.Data;

/**
 * @author 向振华
 * @date 2018/11/17 14:45
 */
@Data
public class ShallowPrototype implements Cloneable {

    private String x;
    private Prototype prototype;

    @Override
    public ShallowPrototype clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (ShallowPrototype) clone;

    }
}

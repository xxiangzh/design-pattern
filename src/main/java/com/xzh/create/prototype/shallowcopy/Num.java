package com.xzh.create.prototype.shallowcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 向振华
 * @date 2018/11/17 14:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Num implements Cloneable{

    private int a;
    private int b;

    @Override
    public Num clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (Num) clone;
    }
}

package com.xzh.create.prototype.deepcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 向振华
 * @date 2018/11/17 14:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field implements Cloneable{
    private int a;

    @Override
    public Field clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (Field) clone;
    }
}

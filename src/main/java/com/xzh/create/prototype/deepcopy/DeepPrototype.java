package com.xzh.create.prototype.deepcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 向振华
 * @date 2018/11/17 15:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeepPrototype implements Cloneable{
    private String d;
    private Field field;
    @Override
    public DeepPrototype clone(){
        Object clone = null;
        try {
            clone = super.clone();
            //将引用类型重新克隆
            ((DeepPrototype)clone).field = this.field.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (DeepPrototype) clone;
    }
}

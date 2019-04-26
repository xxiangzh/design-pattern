package com.xzh.structure.strategy.basics;

/**
 * @author 向振华
 * @date 2019/04/26 14:44
 */
public enum  AlgorithmType {

    /**
     * A算法
     */
    A(1,"A算法"),

    /**
     * B算法
     */
    B(2,"B算法");

    AlgorithmType(int type, String value) {
        this.type = type;
        this.value = value;
    }

    private int type;
    private String value;

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}

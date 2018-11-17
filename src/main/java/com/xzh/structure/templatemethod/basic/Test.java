package com.xzh.structure.templatemethod.basic;

/**
 * @author 向振华
 * @date 2018/11/17 15:43
 */
public class Test {

    public static void main(String[] args) {
        PageBuilder pageBuilder = new MyPageBuilder();
        System.out.println(pageBuilder.bulidHtml());
    }
}

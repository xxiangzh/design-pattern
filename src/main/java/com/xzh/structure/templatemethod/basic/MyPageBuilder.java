package com.xzh.structure.templatemethod.basic;

/**
 * @author 向振华
 * @date 2018/11/17 15:42
 */
public class MyPageBuilder extends AbstractPageBuilder{
    @Override
    protected void appendHead(StringBuffer stringBuffer) {
        stringBuffer.append("<head><title>你好</title></head>");
    }

    @Override
    protected void appendBody(StringBuffer stringBuffer) {
        stringBuffer.append("<body><h1>你好,世界！</h1></body>");
    }

}

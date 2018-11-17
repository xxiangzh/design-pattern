package com.xzh.structure.strategy.eg.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author 向振华
 * @date 2018/11/16 16:52
 */
public class ClassUtils {

    /**
     * 获取指定包下面所有的class文件
     * @param packages 包路径
     * @return
     */
    public static File[] getResources(String packages){
        try {
            URL resource = ClassUtils.class.getClassLoader().getResource(packages.replace(".", "/"));
            if (resource == null){
                return null;
            }
            File file = new File(resource.toURI());
            return file.listFiles(pathName -> pathName.getName().endsWith(".class"));
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到资源");
        }
    }
}

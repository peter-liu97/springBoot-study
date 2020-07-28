package com.luban.controller;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class TestImportSelector implements ImportSelector {
    /**
     *返回一个字符串数组 里面包含了需要被Spring容器初始化的类的全路径名
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.luban.config.AppConfig"};
    }
}

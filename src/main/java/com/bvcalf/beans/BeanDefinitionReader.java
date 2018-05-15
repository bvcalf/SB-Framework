package com.bvcalf.beans;

/**
 * 从配置中读取  BeanDefinitionReader
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;

}

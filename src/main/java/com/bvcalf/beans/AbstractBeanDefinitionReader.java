package com.bvcalf.beans;

import com.bvcalf.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 从配置中读取BeanDefinitionReader
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    //Todo 这个类有什么作用，为什么没有实现接口的方法，为什么做成抽象类
    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;//TODO 谁调了getInputStream这个方法

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}

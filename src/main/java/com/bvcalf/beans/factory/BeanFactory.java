package com.bvcalf.beans.factory;
/**
 * bean的容器
 */

public interface BeanFactory {
    //Todo 为什么要抽象出这个接口来

    /**
     * 根据name获取bean
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;
}

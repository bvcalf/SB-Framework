package com.bvcalf.context;

import com.bvcalf.beans.factory.AbstractBeanFactory;

/**
 * TODO 这是干啥的
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    //TODO 为什么要用这个 AbstractBeanFactory
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}

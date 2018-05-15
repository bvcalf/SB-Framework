package com.bvcalf.beans.factory;

import com.bvcalf.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 封装beanDefinitionMap、beanDefinitionNames
 * 实现接口方法
 * 抽象方法子类实现
 *
 * 。。。
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    /**
     * 实现接口
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        //todo 干啥的 根据name获取bean
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    /**
     * 注册bean
     * @param name
     * @param beanDefinition
     * @throws Exception
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    //todo 干啥的
    /**
     * 预先 实例化 单例
     * @throws Exception
     */
    public void preInstantiateSingletons() throws Exception {
        //todo 这是遍历list么，这种写法有啥好处？
        //TODO 这时 已经实例化了么？
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            //调用上面实现的接口
            getBean(beanName);
        }
    }

    /**
     * 初始化bean
     * 抽象方法，需要子类实现
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}

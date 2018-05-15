package com.bvcalf.context;

import com.bvcalf.beans.BeanDefinition;
import com.bvcalf.beans.factory.AbstractBeanFactory;
import com.bvcalf.beans.factory.AutowireCapableBeanFactory;
import com.bvcalf.beans.io.ResourceLoader;
import com.bvcalf.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * TODO 这个包下的内容完全没有看
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}

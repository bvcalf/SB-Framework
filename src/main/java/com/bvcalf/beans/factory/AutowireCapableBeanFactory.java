package com.bvcalf.beans.factory;

import com.bvcalf.BeanReference;
import com.bvcalf.beans.BeanDefinition;
import com.bvcalf.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * 可自动装配内容的BeanFactory
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 抽象类定义，需要子类实现的方法
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    /**
     * todo 反射实现类实例化？
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }

}

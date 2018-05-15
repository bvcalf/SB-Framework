package com.bvcalf.beans.xml;

import com.bvcalf.beans.BeanDefinition;
import com.bvcalf.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class XmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }
}

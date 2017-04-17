package com.guge.spring.beans.factory;

import com.guge.spring.beans.entity.UrlResource;
import com.guge.spring.beans.xml.XmlBeanDefinitionReader;

/**
 * 基于XML实现的beanFactory
 * Created by google on 16/12/14.
 */

public class XmlBeanFactory extends DefaultBeanFactory {
    //xml读取
    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);
    //构造函数
    public XmlBeanFactory(UrlResource resource) throws Exception {
        this.reader.loadBeanDefinitions(resource);
    }
    //构造函数
    public XmlBeanFactory(String location) throws Exception {
        this.reader.loadBeanDefinitions(location);
    }
}

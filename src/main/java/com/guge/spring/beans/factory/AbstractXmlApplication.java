package com.guge.spring.beans.factory;

import com.guge.spring.beans.entity.UrlResource;
import com.guge.spring.beans.support.BeanDefinitionReader;
import com.guge.spring.beans.xml.XmlBeanDefinitionReader;

/**
 * Created by google on 17/4/16.
 */
public abstract class AbstractXmlApplication extends AbstractRefreshApplicationContext{
    @Override
    void loadBeanDefition(DefaultBeanFactory beanFactory) throws Exception{
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(getConfigResources());
    }

    protected UrlResource[] getConfigResources() {
        return null;
    }

    /**
     * 根据bean的名称获取实体
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        return getBeanFactory().getBean(name);
    }

    @Override
    void postBeanDefiniton() throws Exception{
        this.getBeanFactory().preInstantiateSingletons();
    }
}

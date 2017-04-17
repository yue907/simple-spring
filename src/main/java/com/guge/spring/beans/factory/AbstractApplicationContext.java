package com.guge.spring.beans.factory;

import com.guge.spring.beans.io.DefaultResourceLoader;

/**
 * Created by google on 17/4/16.
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements BeanFactory {
    public void refresh() throws Exception {
        prepareRefresh();
        try {
            BeanFactory beanFactory = obtainFreshBeanFactory();
            postBeanDefiniton();

        } catch (Exception ex) {
            destroyBeans();
            throw ex;
        }
    }

    private ConfigurableListableBeanFactory obtainFreshBeanFactory() throws Exception{
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        return beanFactory;
    }

    abstract void refreshBeanFactory() throws Exception;

    abstract ConfigurableListableBeanFactory getBeanFactory();

    abstract void prepareRefresh();

    abstract void destroyBeans();

    abstract void postBeanDefiniton() throws Exception;

}

package com.guge.spring.beans.factory;

/**
 * Created by google on 17/4/16.
 */
public abstract class AbstractRefreshApplicationContext extends AbstractApplicationContext {
    private DefaultBeanFactory beanFactory;

    @Override
    void refreshBeanFactory() throws Exception{
        if(null == beanFactory){
            beanFactory = new DefaultBeanFactory();
        }
        loadBeanDefition(beanFactory);
    }

    @Override
    ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    void prepareRefresh() {

    }

    @Override
    void destroyBeans() {
        beanFactory.destoryBeans();
    }
    abstract void loadBeanDefition(DefaultBeanFactory beanFactory) throws Exception;
}

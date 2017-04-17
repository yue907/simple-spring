package com.guge.spring.beans.factory;

/**
 * Created by google on 17/4/16.
 */
public interface ConfigurableListableBeanFactory extends BeanFactory{
    void preInstantiateSingletons() throws Exception;
    void destoryBeans();
}

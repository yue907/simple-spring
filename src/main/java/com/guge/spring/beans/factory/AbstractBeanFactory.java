package com.guge.spring.beans.factory;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by google on 17/4/15.
 */
public abstract class AbstractBeanFactory implements BeanFactory,ConfigurableListableBeanFactory{
    /**
     * 根据bean的名称获取实体
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        return doGetBean(name);
    }

    abstract Object doGetBean(String name)throws Exception;
}

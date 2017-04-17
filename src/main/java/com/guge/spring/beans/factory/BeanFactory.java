package com.guge.spring.beans.factory;

/**
 * bean工厂接口
 * Created by google on 16/11/20.
 */
public interface BeanFactory {
    /**
     * 根据bean的名称获取实体
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;
}

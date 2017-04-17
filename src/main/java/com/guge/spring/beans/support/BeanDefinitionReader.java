package com.guge.spring.beans.support;

import com.guge.spring.beans.entity.UrlResource;

/**
 * 读取beanDefinition接口
 * Created by google on 16/12/14.
 */

public interface BeanDefinitionReader {
    /**
     * 根据URL资源获取BeanDefinition
     * @param resource
     * @return
     * @throws Exception
     */
    int loadBeanDefinitions(UrlResource resource) throws Exception;

    /**
     * 根据URL资源批量获取BeanDefinition
     * @param resources
     * @return
     * @throws Exception
     */
    int loadBeanDefinitions(UrlResource[] resources) throws Exception;

    /**
     * 根据路径获取BeanDefinition
     * @param location
     * @return
     * @throws Exception
     */
    int loadBeanDefinitions(String location) throws Exception;

    /**
     *  根据路径批量获取BeanDefinition
     * @param locations
     * @return
     * @throws Exception
     */
    int loadBeanDefinitions(String[] locations) throws Exception;
}

package com.guge.spring.beans.support;

import com.guge.spring.beans.entity.Bean;
import com.guge.spring.beans.entity.Beans;

/**
 * Created by google on 17/4/16.
 */
public interface BeanDefinitionRegistry {
    void registryBeanDefinition(Beans beans) throws Exception;
    void registryBeanDefinition(String beanName,Bean bean);
}

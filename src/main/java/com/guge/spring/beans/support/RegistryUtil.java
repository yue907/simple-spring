package com.guge.spring.beans.support;

import com.guge.spring.beans.entity.Beans;

/**
 * Created by google on 17/4/16.
 */
public class RegistryUtil {
    public static void registry(Beans beans,BeanDefinitionRegistry registry) throws Exception{
        registry.registryBeanDefinition(beans);
    }
}

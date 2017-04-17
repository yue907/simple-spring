package com.guge.spring.beans.factory;

import com.guge.spring.beans.context.AnnotationUtil;
import com.guge.spring.beans.context.PropertyUtil;
import com.guge.spring.beans.entity.Bean;
import com.guge.spring.beans.entity.Beans;
import com.guge.spring.beans.entity.Property;
import com.guge.spring.beans.entity.Scan;
import com.guge.spring.beans.support.CheckUtil;
import com.guge.spring.beans.support.BeanDefinitionRegistry;
import com.guge.spring.beans.util.ReflectUtil;
import com.guge.spring.beans.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Field;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by google on 17/4/15.
 */
public class DefaultBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {
    Set<String> beanNames = new HashSet<String>();
    private Map<String,Object> singletonBeans = new ConcurrentHashMap<String, Object>();
    private Map<String,Bean> beanDefinitionMap = new ConcurrentHashMap<String, Bean>();
    @Override
    Object doGetBean(String name) throws Exception{
        if(singletonBeans.containsKey(name)){
            return singletonBeans.get(name);
        }

        return getBeanFromDefinition(name);
    }

    @Override
    public void registryBeanDefinition(Beans beans) throws Exception{
        CheckUtil.checkNullArgs("beans can not bu null", beans);
        List<Bean> beanList = beans.getBeans();
        List<Scan> scanList = beans.getScans();
        if(CollectionUtils.isNotEmpty(beanList)){
            for(Bean bean : beanList){
                registryBeanDefinition(bean.getId(),bean);
            }
        }
        if(CollectionUtils.isNotEmpty(scanList)){
            for(Scan scan : scanList){
                AnnotationUtil.injectAnnotation(scan.getPackageName(),this);
            }
        }

    }

    @Override
    public void registryBeanDefinition(String beanName, Bean bean) {
        CheckUtil.checkBlankStr("beanName can not be blank", beanName);
        CheckUtil.checkNullArgs("bean definition can not be null",bean);
        if(beanDefinitionMap.containsKey(beanName)){
            throw new IllegalArgumentException("beanName has existed!");
        }
        beanDefinitionMap.put(beanName, bean);
        beanNames.add(beanName);
    }
    private Object getBeanFromDefinition(String name) throws Exception{
        Bean bean = beanDefinitionMap.get(name);
        if(null == bean){
            return null;
        }
        Class clazz = Class.forName(bean.getClassName());
        singletonBeans.put(bean.getId(), clazz.newInstance());
        injectDependences(name, bean.getProps());
        return singletonBeans.get(name);
    }

    private void injectDependences(String name,List<Property> properties) throws Exception{
        if(CollectionUtils.isEmpty(properties)){
            return;
        }
        Object item = singletonBeans.get(name);
        if(null == item){
            return;
        }
        for(Property property : properties){
            String propertyName = property.getName();

            Field field = ReflectUtil.getDeclaredField(item, propertyName);
            String methodName = StringUtil.setMethodName(propertyName);
            Method m = ReflectUtil.getDeclaredMethod(item, methodName, field.getType());
            if (null != property.getValue()) {
                // 其实这里应该尝试进行 prop.getValue() 到 field.getType()的转换
                m.invoke(item, PropertyUtil.getPorperty(field.getType(),property.getValue()));
            }
            if (null != property.getRef()) {
                Object refObj = getBean(property.getRef());
                m.invoke(item, refObj);
            }
        }

    }

    public void destoryBeans(){
        singletonBeans.clear();
        beanDefinitionMap.clear();
        beanNames.clear();
    }

    public void preInstantiateSingletons() throws Exception{
        if(beanNames.isEmpty()){
            return;
        }
        for(String beanName : beanNames){
            getBean(beanName);
        }
    }
}

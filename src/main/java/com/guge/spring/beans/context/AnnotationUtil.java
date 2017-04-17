package com.guge.spring.beans.context;


import com.guge.spring.beans.annotation.Component;
import com.guge.spring.beans.annotation.Prop;
import com.guge.spring.beans.entity.Bean;
import com.guge.spring.beans.entity.Property;
import com.guge.spring.beans.io.Scanner;
import com.guge.spring.beans.support.BeanDefinitionRegistry;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.util.Iterator;
import java.util.Map;

import java.util.Set;

/**
 * 注册注解类工具
 */
public class AnnotationUtil {
    private static Scanner scanner = new Scanner();

    public static void injectAnnotation(String packageName,BeanDefinitionRegistry registry) throws Exception{

        Set<Class<?>> classes = scanner.scanPackage(packageName);
        createBeansAndScanDependencies(classes,registry);
    }

    /**
     * 扫描注解,创建对象,记录依赖关系
     *
     * @param classes 类集合
     */
    private static void createBeansAndScanDependencies(Set<Class<?>> classes,BeanDefinitionRegistry registry) throws Exception {

        Iterator<Class<?>> iterator = classes.iterator();
        while (iterator.hasNext()) {
            Class<?> item = iterator.next();
            Component annotation = item.getAnnotation(Component.class);
            Bean bean = new Bean();
            if (annotation != null) {
                String beanName = annotation.value();
                bean.setId(beanName);
                bean.setClassName(item.getName());
                Field[] fields = item.getDeclaredFields();

                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];

                    Prop prop = field.getAnnotation(Prop.class);
                    Property property = new Property();
                    if (prop != null) {
                        //获取依赖的bean的名称,如果为null,则使用字段名称
                        String value = prop.value();
                        String ref = prop.ref();
                        property.setName(field.getName());
                        if (StringUtils.isNotBlank(ref)) {
                            property.setRef(ref);
                            property.setValue(null);
                        }else {
                            property.setRef(null);
                            property.setValue(value);
                        }
                        bean.addProperty(property);
                    }

                }
                registry.registryBeanDefinition(beanName, bean);
            }
        }
    }


}

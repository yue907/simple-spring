package com.guge.spring.beans.xml;

import com.guge.spring.beans.entity.Beans;
import com.guge.spring.beans.entity.UrlResource;
import com.guge.spring.beans.io.DefaultResourceLoader;
import com.guge.spring.beans.io.DigesterUtil;
import com.guge.spring.beans.support.BeanDefinitionReader;

import com.guge.spring.beans.support.CheckUtil;
import com.guge.spring.beans.support.BeanDefinitionRegistry;
import com.guge.spring.beans.support.RegistryUtil;

/**
 * 通过XML文件读取beanDefinition
 * Created by google on 16/12/14.
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    //beandefinition注册接口
    private final BeanDefinitionRegistry registry;
    private DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

    /**
     * 构造函数
     *
     * @param registry
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * 根据URL资源获取BeanDefinition
     *
     * @param resource
     * @return
     * @throws Exception
     */
    @Override
    public int loadBeanDefinitions(UrlResource resource) throws Exception {
        if(null == resource){
            throw new IllegalArgumentException("resource can not be null");
        }
        Beans beans = DigesterUtil.parseSource(resource);
        RegistryUtil.registry(beans,this.registry);
        return 1;
    }

    /**
     * 根据URL资源批量获取BeanDefinition
     *
     * @param resources
     * @return
     * @throws Exception
     */
    @Override
    public int loadBeanDefinitions(UrlResource[] resources) throws Exception {
        if(null == resources){
            throw new IllegalArgumentException("resources can not be null");
        }
        int count = 0;
        for(UrlResource resource : resources){
            count += loadBeanDefinitions(resource);
        }
        return count;
    }

    /**
     * 根据路径获取BeanDefinition
     *
     * @param location
     * @return
     * @throws Exception
     */
    @Override
    public int loadBeanDefinitions(String location) throws Exception {
        CheckUtil.checkBlankStr(location);
        UrlResource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
        return 1;
    }

    /**
     * 根据路径批量获取BeanDefinition
     *
     * @param locations
     * @return
     * @throws Exception
     */
    @Override
    public int loadBeanDefinitions(String[] locations) throws Exception {
        CheckUtil.checkBlankStr("source locations can not be null",locations);
        int count = 0;
        for(String location : locations){
            count += loadBeanDefinitions(location);
        }
        return count;
    }

    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }
}

package com.guge.spring.beans.io;

import com.guge.spring.beans.entity.UrlResource;
import com.guge.spring.beans.support.ResourceLoader;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 默认的资源加载实现类
 * Created by google on 16/12/14.
 */
public class DefaultResourceLoader implements ResourceLoader{
    /**
     * 根据路径加载资源,暂时不支持加载其它jar包中的配置
     *
     * @param location
     * @return
     */
    @Override
    public UrlResource getResource(String location) {
        try {
            URL url = Thread.currentThread().getClass().getResource(location);
            return new UrlResource(url);
        }
        catch ( Exception ex) {
            return null;
        }
    }

    @Override
    public UrlResource[] getResources(String[] locations) {
        if(null == locations){
            return null;
        }
        UrlResource[] urlResources = new UrlResource[locations.length];
        for(int i=0;i<locations.length;i++){
            urlResources[i] = getResource(locations[i]);
        }
        return urlResources;
    }
}

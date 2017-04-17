package com.guge.spring.beans.support;

import com.guge.spring.beans.entity.UrlResource;

/**
 * 加载resource资源-接口
 * Created by google on 16/12/14.
 */
public interface ResourceLoader {
    /**
     * 根据路径加载资源
     * @param location
     * @return
     */
    UrlResource getResource(String location);

    UrlResource[] getResources(String[] locations);
}

package com.guge.spring.beans.entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 配置资源--实体类
 * Created by google on 16/12/14.
 */
public class UrlResource {
    //资源的URL
    private final URL url;

    /**
     * 构造函数
     * @param url
     */
    public UrlResource(URL url) {
        this.url = url;
    }

    /**
     * 构造函数
     * @param path
     * @throws MalformedURLException
     */
    public UrlResource(String path) throws MalformedURLException {
        this.url = new URL(path);
    }

    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        con.setUseCaches(false);
        return con.getInputStream();
    }

    public URL getUrl() {
        return url;
    }
}

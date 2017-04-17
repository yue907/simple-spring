package com.guge.spring.beans.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by google on 17/4/15.
 */
public class Beans {
    private List<Scan> scans = new ArrayList<Scan>();
    private List<Bean> beans = new ArrayList<Bean>();
    public List<Bean> getBeans() {
        return beans;
    }

    public void setBeans(List<Bean> beans) {
        this.beans = beans;
    }

    public void addBean(Bean bean) {
        this.beans.add(bean);
    }

    public List<Scan> getScans() {
        return scans;
    }

    public void setScans(List<Scan> scans) {
        this.scans = scans;
    }
    public void addScan(Scan scan){
        this.scans.add(scan);
    }
}

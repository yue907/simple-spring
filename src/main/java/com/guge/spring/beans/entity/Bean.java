package com.guge.spring.beans.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by google on 17/4/15.
 */
public class Bean {
    private String className;
    private String id;
    private List<Property> props=new ArrayList<Property>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Property> getProps() {
        return props;
    }

    public void setProps(List<Property> props) {
        this.props = props;
    }
    public void addProperty(Property property){
        this.props.add(property);
    }
}

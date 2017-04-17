package com.guge.spring.beans.factory;

import com.guge.spring.beans.entity.UrlResource;
import com.guge.spring.beans.support.CheckUtil;

/**
 * Created by google on 17/4/16.
 */
public class XmlApplicationContext extends AbstractXmlApplication {
    private String[] configLocations;

    public XmlApplicationContext(String... locations) throws Exception {
        this(true, locations);
    }

    public XmlApplicationContext(boolean refresh, String... locations) throws Exception {
        setConfigLocations(locations);
        if (refresh) {
            refresh();
        }
    }

    public XmlApplicationContext(String location) throws Exception {
        this(new String[]{location});
    }

    public void setConfigLocations(String[] locations) {
        if (locations != null) {
            CheckUtil.checkBlankStr("Config locations can not be null", locations);
            this.configLocations = new String[locations.length];
            for (int i = 0; i < locations.length; i++) {
                this.configLocations[i] = locations[i].trim();
            }
        } else {
            this.configLocations = null;
        }
    }

    @Override
    protected UrlResource[] getConfigResources() {
        if (null == configLocations) {
            return null;
        }
        return getResources(configLocations);
    }
}

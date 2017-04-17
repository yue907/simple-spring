package com.guge.spring.beans.io;

import com.guge.spring.beans.entity.*;
import com.guge.spring.beans.support.CheckUtil;
import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by google on 17/4/16.
 */
public class DigesterUtil {
    private static Digester digester = new Digester();
    static {
        digester.setValidating(false);
        digester.addObjectCreate("beans", Beans.class);
        // 如果配置文件中有多个bean，add一次即可
        digester.addObjectCreate("beans/bean", Bean.class);
        // 设置bean的属性<bean name="",id="">中的id和name。默认属性名和类中的属性名一样，不同的要特殊配置
        digester.addSetProperties("beans/bean", "class", "className");
        digester.addSetProperties("beans/bean");
        digester.addObjectCreate("beans/bean/property", Property.class);
        digester.addSetProperties("beans/bean/property");
        digester.addObjectCreate("beans/scan", Scan.class);
        digester.addSetProperties("beans/scan");
        // 设置对象间的关系
        digester.addSetNext("beans/bean/property", "addProperty");
        digester.addSetNext("beans/bean", "addBean");
        digester.addSetNext("beans/scan", "addScan");
    }
    public static Beans parseSource( UrlResource urlResource) throws IOException,SAXException{
        CheckUtil.checkNullArgs("urlResource can not be null",urlResource);
        Beans beans = (Beans) digester.parse(urlResource.getInputStream());
        return beans;
    }
}

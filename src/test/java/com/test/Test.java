package com.test;

import com.alibaba.fastjson.JSON;
import com.guge.spring.beans.factory.XmlApplicationContext;
import com.test.entity.Note;

/**
 * Created by google on 17/4/17.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        XmlApplicationContext applicationContext = new XmlApplicationContext("/config/context.xml");
        Note note = (Note)applicationContext.getBean("note");
        System.out.println(JSON.toJSONString(note));

    }
}

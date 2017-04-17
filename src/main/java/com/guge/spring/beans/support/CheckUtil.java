package com.guge.spring.beans.support;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by google on 17/4/16.
 */
public class CheckUtil {
    public static void checkNullArgs(String msg,Object... objects){
        for(Object object : objects){
            if(null == object){
                throw new IllegalArgumentException("args exception: "+msg);
            }
        }
    }

    public static void checkBlankStr(String msg,String... args){
        for(String arg : args){
            if(StringUtils.isBlank(arg)){
                throw new IllegalArgumentException("args exception: "+msg);
            }
        }
    }

    public static void checkEmptyList(String msg,List... lists){
        for(List list : lists){
            if(CollectionUtils.isEmpty(list)){
                throw new IllegalArgumentException("args exception: "+msg);
            }
        }
    }
}

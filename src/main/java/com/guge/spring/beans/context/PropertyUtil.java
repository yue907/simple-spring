package com.guge.spring.beans.context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by google on 17/4/14.
 */
public class PropertyUtil {
    public static Object getPorperty(Class<?> cls,String value){
        if(null == cls){
            throw new IllegalArgumentException("property class can not be null");
        }
        if(cls == int.class || cls == Integer.class){
            return NumberUtils.toInt(value);
        }
        if(cls == double.class || cls == Double.class){
            return NumberUtils.toDouble(value);
        }
        if(cls == short.class || cls == Short.class){
            return NumberUtils.toShort(value);
        }
        if(cls == float.class || cls == Float.class){
            return NumberUtils.toShort(value);
        }
        if(cls == boolean.class || cls == Boolean.class){
            return "true".equals(value);
        }
        if(cls == String.class){
            return value;
        }
       return null;
    }
}

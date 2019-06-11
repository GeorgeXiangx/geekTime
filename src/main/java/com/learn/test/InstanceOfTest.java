package com.learn.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XJH on 2019/4/15.
 *
 * @Description:
 */
public class InstanceOfTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        Field[] declaredFields = list.getClass().getDeclaredFields();
        for (Field f : declaredFields) {
            if (f.getType() == java.util.List.class) {
                Type type = f.getGenericType();
                if (type == null) continue;
                if (type instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) type;
                    Class<?> aClass = (Class<?>) pt.getActualTypeArguments()[0];
                }
            }
        }

//        if (list instanceof List<String>){
        System.out.println(list.getClass().getTypeParameters().toString());
//        }
    }
}

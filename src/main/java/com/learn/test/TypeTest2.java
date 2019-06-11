package com.learn.test;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

class People<U,V,T>{}

public class TypeTest2<T> {
    private People<String,List<String>,T> People;


    public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
        Type t = TypeTest2.class.getDeclaredField("People").getGenericType();
        ParameterizedType pt = (ParameterizedType)t;
        Type[] types = pt.getActualTypeArguments();
        for( int i = 0; i < types.length; i++ ){
            printType(types[i].toString(), types[i]);
        }
    }
    public static void printType(String name, Type type){
        if( type instanceof Class ){
            System.out.println("the type of " + name + " is : Class");
        }else if( type instanceof ParameterizedType ){
            System.out.println("the type of " + name + " is : ParameterizedType");
        }else if( type instanceof GenericArrayType){
            System.out.println("the type of " + name + " is : GenericArrayType");
        }else if( type instanceof TypeVariable){
            System.out.println("the type of " + name + " is : TypeVariable");
        }

    }
}
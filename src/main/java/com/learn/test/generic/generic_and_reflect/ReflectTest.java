package com.learn.test.generic.generic_and_reflect;

import java.lang.reflect.Constructor;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:泛型和反射
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 使用泛型
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();

        // 不使用泛型
        Class clazz = Person.class;
        Constructor constructor1 = clazz.getConstructor();
        Object o = constructor1.newInstance();
        // 这里还需要强转
        Person person1 = (Person) o;
    }
}

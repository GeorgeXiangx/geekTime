package com.learn.test.generic.clazz;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:子类泛型类
 * 泛型类派生子类，子类也是泛型类，那么子类的泛型标识要和父类一致
 */
public class FirstChildGeneric<T> extends ParentGeneric<T> {

    @Override
    public T getValue() {
        return super.getValue();
    }

    public static void main(String[] args) {
        ParentGeneric<String> childFirst = new FirstChildGeneric<>();
        childFirst.setValue("son");
        System.out.println(childFirst.getValue());
    }
}

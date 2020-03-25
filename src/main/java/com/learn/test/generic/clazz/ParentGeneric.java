package com.learn.test.generic.clazz;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:父类泛型类
 */
public class ParentGeneric<E> {

    E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}

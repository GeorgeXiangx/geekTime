package com.learn.test.generic.clazz;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:如果子类不是泛型类，那么父类要明确数据类型
 */
public class SecondChildGeneric extends ParentGeneric<Integer> {

    @Override
    public Integer getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Integer value) {
        super.setValue(value);
    }

    public static void main(String[] args) {
        ParentGeneric secondChildGeneric = new SecondChildGeneric();
        secondChildGeneric.setValue(100);
        System.out.println(secondChildGeneric.getValue());
    }
}

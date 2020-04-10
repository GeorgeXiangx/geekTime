package com.learn.test.generic.wildcard.type_erasure;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:类型擦除：泛型类型只存于程序的编译器(编译时会进行相应的检查)。编译完成之后类型会被擦除
 */
public class ErasureTest<T extends Number> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    /**
     * 泛型方法
     * @param t
     * @param <T>
     * @return
     */
    public <T extends List> T show(T t) {
        return t;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> intList = new ArrayList<>();
//        ArrayList<String> strList = new ArrayList<>();
//
//        System.out.println(intList.getClass().getSimpleName());
//        System.out.println(strList.getClass().getSimpleName());
//        System.out.println(intList.getClass() == strList.getClass());

        // 1.无限制类型擦除: <T> ----> Object
        // 2.有限制类型擦除: <T extends Number> ----> Number 将类型全部转换为了上限类型Number
        // 3.桥接方法：保持接口和实现类的实现关系

        // 1.无限制类型擦除
        // 反射获取ErasureTest类的所有成员信息并打印
        ErasureTest<Integer> integerErasureTest = new ErasureTest<>();
        Class<? extends ErasureTest> intClazz = integerErasureTest.getClass();
        Field[] fields = intClazz.getDeclaredFields();
        for (Field field : fields) {
            // 编译结束后会对类型进行擦除
            System.out.println(field.getName() + " : " + field.getType().getSimpleName());
        }

        System.out.println("-----------------------");
        // 2.有限制类型擦除
        Method[] declaredMethods = intClazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + " " + declaredMethod.getReturnType().getSimpleName());
        }

        System.out.println("-----------------------");
        // 3.查看泛型接口实现类中的桥接方法
        InfoImpl info = new InfoImpl();
        Method[] declaredMethods1 = info.getClass().getDeclaredMethods();
        int count = 0;

        for (Method method : declaredMethods1) {
            if (method.getReturnType().getSimpleName().equals(Object.class.getSimpleName())) {
                System.out.println("编译器生成的桥接方法 : " + method.getName() + " " + method.getReturnType().getSimpleName());
            }
            System.out.println(method.getName() + " " + method.getReturnType().getSimpleName());
            count++;
        }
        System.out.println("共" + count + "个方法");
    }
}

// 定义一个泛型接口
interface Info<T> {
    T getInfo(T t);
}

// 实现类
class InfoImpl implements Info<Integer> {

    @Override
    public Integer getInfo(Integer value) {
        return value;
    }

    // 这里编译器会为我们自动生成一个桥接方法用于保持接口和类的实现关系
    /*
    * @Override
    * public Object getInfo(Object value) {
    *   return getInfo((Integer)value);
    * }
    * */
}
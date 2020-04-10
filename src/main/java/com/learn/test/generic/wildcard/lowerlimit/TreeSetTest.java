package com.learn.test.generic.wildcard.lowerlimit;

import com.learn.test.generic.wildcard.upperlimit.Animal;
import com.learn.test.generic.wildcard.upperlimit.Cat;
import com.learn.test.generic.wildcard.upperlimit.MiniCat;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:
 */
public class TreeSetTest {
    public static void main(String[] args) {
//        TreeSet<Cat> treeSet = new TreeSet<>(new Comparator2());
        TreeSet<Cat> treeSet = new TreeSet<>(new Comparator1());

        // 通配符下限只能传入E及E的父类类型
        //        TreeSet<Cat> treeSet = new TreeSet<>(new Comparator3());

        treeSet.add(new Cat("Jerry", 20));
        treeSet.add(new Cat("Amy", 22));
        treeSet.add(new Cat("Frank", 35));
        treeSet.add(new Cat("Jim", 15));

        for (Cat cat : treeSet) {
            System.out.println(cat);
        }
    }
}

class Comparator1 implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Comparator2 implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.age - o2.age;
    }
}

class Comparator3 implements Comparator<MiniCat> {

    @Override
    public int compare(MiniCat o1, MiniCat o2) {
        return o1.level - o2.level;
    }
}

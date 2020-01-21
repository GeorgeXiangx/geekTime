package com.learn.test.deep_copy;

import com.learn.test.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by XJH on 2019/12/3.
 *
 * @Description:
 */
public class Copy implements Cloneable {
    public int value;
    public String str;
    public String[] strList;
    public List<Person> personList;
    public Person person;
    public Ex ex;
    public Date date;

    @Override
    public String toString() {
        String sstr = "";
        String pstr = "";

        for (Person p : this.personList) {
            pstr += p.getName() + " : " + p.getAge();
        }
        for (String s : this.strList) {
            sstr += s + " ";
        }

        return "Copy{" +
                "value=" + value +
                ", str='" + str + '\'' +
                ", strList=" + sstr +
                ", personList=" + pstr +
                ", ex=" + ex +
                ", person=" + person +
                ", date=" + date +
                '}';
    }

    public enum Ex {
        One, Two, Three
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> sl = new ArrayList();
        sl.add("a");
        sl.add("b");

        String[] s2 = new String[]{"c", "d"};

        List<Person> pl = new ArrayList<>();
        Person person = new Person();
        person.setName("Java");
        person.setAge(11);
        pl.add(person);
        Date date = new Date();


        Copy copy = new Copy();
        copy.str = "123";
        copy.value = 100;
        copy.personList = pl;
        copy.strList = s2;
        copy.ex = Ex.Three;
        copy.person = person;
        copy.date = date;

        Copy copy2 = (Copy) copy.clone();
        copy2.str = "888";
        copy2.value = 2000;
        copy2.strList[0] = "e";
        copy2.personList.get(0).setName("Scala");
        copy2.ex = Ex.Two;
        copy2.person.setName("Haha");
        copy2.date = new Date(1989,2,18);

        System.out.println(copy);
        System.out.println(copy2);
    }
}

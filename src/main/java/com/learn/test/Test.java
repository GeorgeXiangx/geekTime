package com.learn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by XJH on 2019/1/16.
 *
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date();
        System.out.println(System.currentTimeMillis());

        System.out.println(sdf.format(date));

        String time = "201412011359";
        try {
            Date d = sdf.parse(time);
            System.out.println(d);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);

            System.out.println(calendar.get(Calendar.HOUR));
            System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println(calendar.get(Calendar.MINUTE));

            Date d2 = new Date();
            calendar.setTime(d2);
            System.out.println(calendar.get(Calendar.HOUR));
            System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println(calendar.get(Calendar.MINUTE));
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        System.out.println(1439 / 5);

//        float[] array = {11.5f, 20.2f};
//        try {
//            ByteArrayOutputStream ba = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(ba);
//            oos.writeObject(array);
//            byte[] pBytes = ba.toByteArray();
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("-----------------");
        int[][] a = new int[3][4];
        System.out.println(a.length);
        System.out.println(a[0].length);
        System.out.println(a[0][0]);

        System.out.println("-----------------");
        List<Person> list = new ArrayList<Person>();

        Person p1 = new Person();
        p1.setAge(10);
        p1.setName("Java");

        Person p2 = new Person();
        p2.setAge(13);
        p2.setName("Scala");

        list.add(p1);
        list.add(p2);

        int count = 0;
        for (Person res : list) {
            count++;
        }
        System.out.println(count);

        for (Person res : list) {
            System.out.println(res);
        }

        System.out.println("-----------------");
        new Hashtable<>();
        new HashMap<>();
        String timeStr = "00073.650000_201903190811_00001003";
        String timeStr2 = "00073.650000_201903190911_00001003";
        double code = timeStr.split("_")[1].hashCode();
        int codeInt = timeStr.split("_")[1].hashCode();
        System.out.println(code);
        System.out.println(codeInt);
        System.out.println(timeStr2.split("_")[1].hashCode());

        Set<Integer> set = new HashSet();
        addSet(set, 1);
        addSet(set, 3);
        addSet(set, 1);
        addSet(set, 4);
        for (int i : set) {
            System.out.println(i);
        }
    }

    public static void addSet(Set set, int i) {
        if (!set.contains(i)) {
            set.add(i);
        }
    }
}

package com.learn.test.test_final_in_anonymous_inner_class;

/**
 * Created by XJH on 2019/10/18.
 *
 * @Description:
 */
public class TestInThread {

    private void test(Person person) {
//        Person person = new Person("Leo", 11);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(person);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
        Person person = new Person("Leo", 11);
        new TestInThread().test(person);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(person);
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            }
//        });
//        thread.start();
//        System.out.println("start the sub thread...");
//
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("done...");
    }
}

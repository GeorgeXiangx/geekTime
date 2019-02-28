package com.learn.concurrentprogramming.practise;


/**
 * Created by XJH on 2019/1/31.
 *
 * @Description:
 */
public class SafePoint {
    //状态变量 x.y
    private int x;
    private int y;

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //synchronized constructor so that the read will synchronize on the same lock
    //but Constructors in Java can not use the synchronized keyword
    public SafePoint(SafePoint safePoint) {
        //除了在有同步方法的get,set方法中能触及到x,y。这里也可以
        //first statement inside a constructor must be a call to this/super.
        //If we implement a different lock then the first line would have to be something like this : lock.lock()
        //即这里不能使用细粒度的锁
//        this(safePoint.x, safePoint.y);

        //*************同步***************
        this(safePoint.getXY());
    }


    //Notice that the constructor is private,
    //this is because we do not want to expose yet another public constructor
    //and think again about the invariants of the class, thus we make it private - and only we can invoke it.
    private SafePoint(int[] xy) {
        this(xy[0], xy[1]);
    }

    //this is a refactored method, instead of a constructor
    public SafePoint cloneSafePoint(SafePoint originalSafePoint) {
        //1.使用线程安全的方法获取x,y的值
        int[] xy = originalSafePoint.getXY();
        //2.返回一个新的对象
        return new SafePoint(xy[0], xy[1]);
    }

    public synchronized int[] getXY() {
        return new int[]{x, y};
    }

    public synchronized void setXY(int x, int y) {
        this.x = x;
        //Simulate some resource intensive work that starts EXACTLY at this point, causing a small delay
        try {
            Thread.sleep(10 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.y = y;
    }

    public String toString() {
        return "x = " + x + " y = " + y;
    }

    public static void main(String[] args) {
        final SafePoint originalSafePoint = new SafePoint(1, 1);

        //One Thread is trying to change this SafePoint
        new Thread(new Runnable() {
            public void run() {
                //one thread updates = writes
                originalSafePoint.setXY(2, 2);
                System.out.println("Original : " + originalSafePoint.toString());
            }
        }).start();

        //The other Thread is trying to create a copy. The copy, depending on the JVM, MUST be either (1,1) or (2,2)
        //depending on which Thread starts first, but it can not be (1,2) or (2,1) for example.
        new Thread(new Runnable() {
            public void run() {
                //other thread is reading from the same object,but they don't do the synchronize
                //SafePoint copySafePoint = new SafePoint(originalSafePoint);

                //1.通过调用线程安全的方法进行同步
                //SafePoint copySafePoint = originalSafePoint.cloneSafePoint(originalSafePoint);

                //2.将同步方法封装到构造方法中
                SafePoint copySafePoint = new SafePoint(originalSafePoint);
                System.out.println("Copy : " + copySafePoint.toString());
            }
        }).start();
    }
}

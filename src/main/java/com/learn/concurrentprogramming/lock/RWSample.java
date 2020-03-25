package com.learn.concurrentprogramming.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by XJH on 2020/2/28.
 *
 * @Description:
 */
public class RWSample {
    private final Map<String, String> map = new TreeMap();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public String get(String key){
        r.lock();
        System.out.println("读锁锁定");
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    public String put(String key, String value) {
        w.lock();
        System.out.println("写锁锁定");
        try {
            return map.put(key, value);
        }finally {
            w.unlock();
        }
    }
}

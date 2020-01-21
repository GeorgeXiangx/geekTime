package com.learn.concurrentprogramming.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * Created by XJH on 2019/9/10.
 *
 * @Description:
 */
public class TestExceptionHandle {
    public static void main(String[] args) {
        CompletableFuture<Integer> f0 = CompletableFuture.supplyAsync(() -> 7 / 0)
                .thenApply(r -> r * 10)
                .exceptionally(e -> 0);

        System.out.println("eeeee");
        System.out.println(f0.join());
        System.out.println("esss");
    }
}

package com.txd.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by YXD on 2017/10/27.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
            for (int i = 0; i < 10; i++) {
                final int index = i;
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cachedThreadPool.execute(new Runnable() {
                    public void run() {
                        System.out.println(index);
                    }
                });
            }

    }
}

package com.yxd.rabbit.send;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by YXD on 2017/10/20.
 */
public class StartProducer implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            try {
                new Producer().send("message"+i);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new StartProducer().run();
    }
}

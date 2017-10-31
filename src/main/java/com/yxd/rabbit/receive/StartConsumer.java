package com.yxd.rabbit.receive;

import com.yxd.rabbit.pro.StartLoadProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by YXD on 2017/10/20.
 */
public class StartConsumer implements Runnable{

    @Override
    public void run() {
        try {
            new Consumer().receive();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //加载资源
        StartLoadProperties.LoadProperties();
        //new StartConsumer().run();
        //启动异步处理消息事件消费者
        new BusinessConsumer().startConsumer();
    }
}

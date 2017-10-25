package com.yxd.rabbit.send;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.yxd.rabbit.body.Message;
import com.yxd.rabbit.connect.ConnectPool;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by YXD on 2017/10/25.
 */
public abstract class CurrencyProducer extends AbstractProducer implements Runnable{

    private Message message;
    @Override
    public void send(Message message) {
        Connection connection = ConnectPool.getInstance().getConnection();
        try {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(exchangceName,exchangceType);
            //发送
            channel.basicPublish(exchangceName,exchangceRouteKey,null,message.getB());
            try {
                channel.close();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //归还给连接池
        ConnectPool.getInstance().putConnection(connection);

    }

    @Override
    public void run() {
        this.send(message);
    }
}

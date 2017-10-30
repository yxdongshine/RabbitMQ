package com.yxd.rabbit.receive;

import com.rabbitmq.client.*;
import com.yxd.rabbit.connect.ConnectPool;

import java.io.IOException;

/**
 * Created by YXD on 2017/10/30.
 */
public class CurrencyConsumer extends AbstractConsumer implements Runnable{
    @Override
    public void receive() {
        Connection connection = ConnectPool.getInstance().getConnection();
        try {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(exchangceName,exchangceType);
            //接受消息
            String queueName = null;
            try {
                queueName = channel.queueDeclare().getQueue();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //绑定路由key
            channel.queueBind(queueName,exchangceName,exchangceRouteKey);
            //自定义消费数据
            com.rabbitmq.client.Consumer innerConsumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body,"utf-8");
                    System.out.println(envelope.getRoutingKey()+":"+message);
                }
            };
            //绑定channel及消费定义
            channel.basicConsume(queueName,true,innerConsumer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        this.receive();
    }
}

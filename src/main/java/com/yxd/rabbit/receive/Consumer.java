package com.yxd.rabbit.receive;

import com.rabbitmq.client.*;
import com.yxd.systeminfrastructure.SingleChannel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by YXD on 2017/10/20.
 */
public class Consumer {

    private static final String EXCHANGCE_NAME = "topic_exchangce";
    private static final String EXCHANGCE_TYPE = "topic";
    private static final String EXCHANGCE_ROUTE_KEY = "route_key";

    public void receive() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        String host = SingleChannel.getConfig("mqIP");
        int port = Integer.parseInt(SingleChannel.getConfig("mqPort"));
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGCE_NAME,EXCHANGCE_TYPE);
        //接受消息
        String queueName = channel.queueDeclare().getQueue();
        //绑定路由key
        channel.queueBind(queueName,EXCHANGCE_NAME,EXCHANGCE_ROUTE_KEY);
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
        //关闭资源
        //channel.close();
        //connection.close();
    }
}

package com.yxd.rabbit.send;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.yxd.systeminfrastructure.SingleChannel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by YXD on 2017/10/20.
 */
public class Producer {

    private static final String EXCHANGCE_NAME = "topic_exchangce";
    private static final String EXCHANGCE_TYPE = "topic";
    private static final String EXCHANGCE_ROUTE_KEY = "route_key";

    public void send(Object obj) throws IOException, TimeoutException {
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
        //发送
        channel.basicPublish(EXCHANGCE_NAME,EXCHANGCE_ROUTE_KEY,null,obj.toString().getBytes());
        channel.close();
        connection.close();
    }
}

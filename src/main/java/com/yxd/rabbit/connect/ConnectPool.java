package com.yxd.rabbit.connect;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.yxd.systeminfrastructure.SingleChannel;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * Created by YXD on 2017/10/24.
 */
public class ConnectPool {

    private Logger log = Logger.getLogger(this.getClass().getName());

    //连接池个数
    private int connectNum = 10;

    private static ConnectPool connectPool = null;
    //rabbitMQ连接工厂初始化
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    //线程池队列
    ConcurrentLinkedQueue<Connection> connectionQueue = new ConcurrentLinkedQueue();

    private ConnectPool(){}

    public static ConnectPool getInstance(){
        synchronized (ConnectPool.class){
            if (null != connectPool){
                connectPool = new ConnectPool();

            }
        }
        return connectPool;
    }

    /**
     * 根据配置初始化connection
     * @return
     */
    private Connection initConnection(){
        //初始化连接池数量
        this.connectNum = Integer.parseInt(SingleChannel.getConfig("connect_num"));

        String host = SingleChannel.getConfig("mqIP");
        int port = Integer.parseInt(SingleChannel.getConfig("mqPort"));
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            log.info("MQ 获取连接connect IO异常");
            e.printStackTrace();
        } catch (TimeoutException e) {
            log.info("MQ 获取连接connect 超时异常");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     *从连接池中获取一个connetion
     * @return
     */
    private Connection getConnection() {
        Connection connection = null;
        if (connectionQueue.size() < connectNum){
            connection = initConnection();
            connectionQueue.offer(connection);
        }else{
            connection = connectionQueue.poll();
        }
        return connection;
    }


    /**
     * 归还连接
     * @return
     */
    private void putConnection(Connection connection) {
        if (connectionQueue.size() < connectNum){
            connectionQueue.offer(connection);
        }
    }


}

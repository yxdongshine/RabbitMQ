package com.yxd.rabbit.send;

import com.yxd.rabbit.body.Message;

/**
 * Created by YXD on 2017/10/25.
 */
public abstract  class AbstractProducer {

    /**
     * 提供默认的主题，交换，路由方式
     */
    public  String exchangceName = "topic_exchangce";
    public  String exchangceType = "topic";
    public  String exchangceRouteKey = "route_key";
    /**
     * 发送消息
     */
    public abstract void send(Message message);


    public String getExchangceName() {
        return exchangceName;
    }

    /**
     * @param exchangceName
     */
    public abstract void setExchangceName(String exchangceName);

    public String getExchangceType() {
        return exchangceType;
    }

    /**
     * @param exchangceType
     */
    public abstract void setExchangceType(String exchangceType);

    public String getExchangceRouteKey() {
        return exchangceRouteKey;
    }

    /**
     * @param exchangceRouteKey
     */
    public abstract void setExchangceRouteKey(String exchangceRouteKey);
}

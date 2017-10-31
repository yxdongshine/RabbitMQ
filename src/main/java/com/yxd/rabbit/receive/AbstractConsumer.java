package com.yxd.rabbit.receive;


/**
 * Created by YXD on 2017/10/30.
 */
public abstract class AbstractConsumer {
    /**
     * 提供默认的主题，交换，路由方式
     */
    public  String exchangceName = "topic_exchangce";
    public  String exchangceType = "topic";
    public  String exchangceRouteKey = "route_key";

    /**
     * 发送消息
     */
    public abstract void receive();

    public String getExchangceName() {
        return exchangceName;
    }

    public void setExchangceName(String exchangceName) {
        this.exchangceName = exchangceName;
    }

    public String getExchangceRouteKey() {
        return exchangceRouteKey;
    }

    public void setExchangceRouteKey(String exchangceRouteKey) {
        this.exchangceRouteKey = exchangceRouteKey;
    }

    public String getExchangceType() {
        return exchangceType;
    }

    public void setExchangceType(String exchangceType) {
        this.exchangceType = exchangceType;
    }
}

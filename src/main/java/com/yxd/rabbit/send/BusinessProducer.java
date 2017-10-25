package com.yxd.rabbit.send;

import com.yxd.Executors.ThreadPool;

/**
 * Created by YXD on 2017/10/25.
 */
public class BusinessProducer extends CurrencyProducer{

    public BusinessProducer(){}

    public void BusinessProducer(String exchangceName,String exchangceType,String exchangceRouteKey){
        setExchangceName(exchangceName);
        setExchangceType(exchangceType);
        setExchangceRouteKey(exchangceRouteKey);
    }
    @Override
    public void setExchangceName(String exchangceName) {
        super.exchangceName = exchangceName;
    }

    @Override
    public void setExchangceType(String exchangceType) {
        super.exchangceType = exchangceType;
    }

    @Override
    public void setExchangceRouteKey(String exchangceRouteKey) {
        super.exchangceRouteKey = exchangceRouteKey;
    }

    /**
     * 提供一个异步发送的方法
     */
    public void asynSend() {
        ThreadPool.getInstance().addTask(this);
    }

}

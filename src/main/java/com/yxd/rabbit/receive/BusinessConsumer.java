package com.yxd.rabbit.receive;

import com.yxd.Executors.ThreadPool;
import com.yxd.rabbit.receive.message.process.factory.CurrencyMessageHandle;
import com.yxd.rabbit.receive.message.process.impl.BusinessMessageHandle;

/**
 * 这里就是具体的消费者类了
 * 利用组合模式
 *    切入相关消费者具体实现的消费消息形式
 * Created by YXD on 2017/10/31.
 */
public class BusinessConsumer extends CurrencyConsumer{

    public void startConsumer(){
        //切入相关的消费者
        CurrencyMessageHandle cmHandle = new BusinessMessageHandle();
        setCmHandle(cmHandle);
        //启动消费者线程
        ThreadPool.getInstance().addTask(this);

    }
}

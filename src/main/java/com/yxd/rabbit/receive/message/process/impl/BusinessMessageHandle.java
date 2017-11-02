package com.yxd.rabbit.receive.message.process.impl;

import com.yxd.rabbit.body.Message;
import com.yxd.rabbit.receive.message.process.factory.CurrencyMessageHandle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by YXD on 2017/10/31.
 */
public class BusinessMessageHandle extends CurrencyMessageHandle{
    @Override
    public void doMessage(Message message) {
        try {
            System.out.println(new String(message.getB(),"utf-8"));
            //这里开始确认处理了消息
            //设置应答该条才做 参数1：确认消息的索引 参数2：false 只确认当前的消息索引号，反之 确认全部小于该数字消息
            getChannel().basicAck(getEnvelope().getDeliveryTag(), false);
            //这里在业务层事物处理事物提交
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            //这里事物回滚
        } catch (IOException e) {
            e.printStackTrace();
            //这里事物回滚
        }
    }
}

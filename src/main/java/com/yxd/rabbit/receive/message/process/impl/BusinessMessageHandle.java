package com.yxd.rabbit.receive.message.process.impl;

import com.yxd.rabbit.body.Message;
import com.yxd.rabbit.receive.message.process.factory.CurrencyMessageHandle;

import java.io.UnsupportedEncodingException;

/**
 * Created by YXD on 2017/10/31.
 */
public class BusinessMessageHandle extends CurrencyMessageHandle{
    @Override
    public void doMessage(Message message) {
        try {
            System.out.println(new String(message.getB(),"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

package com.yxd.rabbit.receive.message.process.factory;

import com.yxd.rabbit.body.Message;
import com.yxd.rabbit.receive.message.process.inter.MessageHandle;

/**
 * Created by YXD on 2017/10/31.
 */
public abstract class CurrencyMessageHandle implements Runnable,MessageHandle{

    public Message message = null;

    @Override
    public void run() {
        doMessage(message);
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

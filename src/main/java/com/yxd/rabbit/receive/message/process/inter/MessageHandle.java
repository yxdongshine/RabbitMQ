package com.yxd.rabbit.receive.message.process.inter;

import com.yxd.rabbit.body.Message;

/**
 * Created by YXD on 2017/10/31.
 */
public interface MessageHandle {

    void doMessage(Message message);

}

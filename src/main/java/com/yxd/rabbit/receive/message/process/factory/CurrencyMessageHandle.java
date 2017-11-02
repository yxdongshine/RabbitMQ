package com.yxd.rabbit.receive.message.process.factory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;
import com.yxd.rabbit.body.Message;
import com.yxd.rabbit.receive.message.process.inter.MessageHandle;

/**
 * Created by YXD on 2017/10/31.
 */
public abstract class CurrencyMessageHandle implements Runnable,MessageHandle{

    private Message message = null;
    private Envelope envelope = null;
    private Channel channel = null;

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

    public Envelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}

package com.yxd.rabbit.body;

import java.io.Serializable;

/**
 * Created by YXD on 2017/10/25.
 */
public class Message implements Serializable{


    public  Message(){
    }

    public  Message(byte[] b){
        this.b = b;
    }

    private byte[] b;

    public byte[] getB() {
        return b;
    }

    public void setB(byte[] b) {
        this.b = b;
    }
}

package com.yxd.rabbit.pro;

import com.yxd.resourcesload.LoadProp;
import com.yxd.systeminfrastructure.SingleChannel;

/**
 * Created by YXD on 2017/10/20.
 */
public class StartLoadProperties {

    public static void main(String[] args) {
        LoadProperties();
        //System.out.println(SingleChannel.getConfig("mqIP"));
        //线程堵塞
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void LoadProperties(){
        String path = "src\\main\\resources\\config.properties";
        LoadProp.readPro(path);
    }
}

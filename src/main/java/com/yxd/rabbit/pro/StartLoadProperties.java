package com.yxd.rabbit.pro;

import com.yxd.resourcesload.LoadProp;

/**
 * Created by YXD on 2017/10/20.
 */
public class StartLoadProperties {

    public static void main(String[] args) {
        LoadProperties();
    }

    public static void LoadProperties(){
        String path = "src\\main\\resources\\config.properties";
        LoadProp.readPro(path);
    }
}

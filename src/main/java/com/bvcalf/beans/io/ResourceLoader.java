package com.bvcalf.beans.io;

import java.net.URL;

public class ResourceLoader {

    //TODO 这个类是干啥的，获取输入流的第一步，很简单的操作，为啥要拆成两个类

    /**
     * 返回封装的urlResource对象，
     * @param location
     * @return
     */
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }

}

package com.study.design.proxy;

/**
 * 代理类
 * @author zcp
 * 2019/12/22 下午3:12
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

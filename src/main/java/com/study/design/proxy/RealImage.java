package com.study.design.proxy;

/**
 * 创建实现接口的实体类。
 * @author zcp
 * 2019/12/22 下午3:12
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

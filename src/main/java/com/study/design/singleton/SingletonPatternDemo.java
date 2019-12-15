package com.study.design.singleton;

/**
 * @author zcp
 * 2019/12/15 上午9:54
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
//        SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        //显示消息
        object.showMessage();

        //通过枚举类获取实现单例
        SingleObjectEn.INSTANCE.showMessage();
    }
}

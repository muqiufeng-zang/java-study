package com.study.design.observer;

/**
 * 观察者模式使用三个类 Subject、Observer 和 Client。Subject 对象带有绑定观察者到 Client 对象和从 Client 对象解绑观察者的方法。
 * 我们创建 Subject 类、Observer 抽象类和扩展了抽象类 Observer 的实体类。
 * 优点： 1、观察者和被观察者是抽象耦合的。 2、建立一套触发机制。
 * 缺点： 1、如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。 2、如果在观察者和观察目标之间有循
 * 环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。 3、观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变
 * 化的，而仅仅只是知道观察目标发生了变化。
 * @author zcp
 * 2019/12/15 上午11:11
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}

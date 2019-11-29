package com.study.collection.znt.Iteratormode;

/**
 * @author  znt
 * @description  迭代器模式学习
 * @Date 2019/11/29
 */
public class ConcreteAggregate implements Aggregate {
    @Override
    public Iterator iterator(){
        return  new ConcreteIterator();
    }
    public class ConcreteIterator implements Iterator{
        @Override
        public Object next(){
            System.out.println("Con!!");
            return null;
        }
        @Override
        public boolean hasNext(){
            System.out.println("hasnext!");
            return true;
        }
    }
    public static void main(String[] args){
        /**
         * 1.因为ConcreteAggregate实现了Aggregate接口的，new操作时，会生成一个Aggregate对象
         * 该对象有一个iterator方法
         * 2.Aggregate对象调用iterator方法方法时，实际上是生成了一个内部类ConcreteIterator对象
         * 3.使用内部类ConcreteIterator对象进行相应的操作
         * 这样做的好处：让用户通过特定的接口访问容器的数据，不需要了解容器内部的数据结构
         * 比如该例子中iterator()\hasNext()\next()都是通用接口方法，而其中的实现方式可以根据具体业务进行实现
         */
        Aggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.iterator();
        if(iterator.hasNext()){
            iterator.next();
        }
    }
}

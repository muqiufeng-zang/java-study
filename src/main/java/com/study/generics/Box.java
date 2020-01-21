package com.study.generics;

/**
 * 泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。
 *
 * 和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛
 * 型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。
 *
 * @author zcp
 * 2020/1/21 下午5:18
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class Box<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add("菜鸟教程");

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());
    }
}

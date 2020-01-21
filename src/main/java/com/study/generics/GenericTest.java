package com.study.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
 * 类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
 * 类型通配符下限通过形如 List<? super Number>来定义，表示类型只能接受Number及其三层父类类型，如 Object 类型的实例。
 *
 * @author zcp
 * 2020/1/21 下午5:22
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class GenericTest {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

        //getUperNumber(name);//1 泛型为String是不在定义范围之内，所以会报错
        getUperNumber(age);//2
        getUperNumber(number);//3
    }

    /**
     * 因为getData()方法的参数是List类型的，所以name，age，number都可以作为这个方法的实参
     * @param data
     */
    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    /**
     * 因为getUperNumber()方法中的参数已经限定了参数泛型上限为Number
     * @param data
     */
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }
}

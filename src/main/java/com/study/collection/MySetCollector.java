package com.study.collection;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @author zcp
 * 2020/1/21 上午11:51
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {

    /**
     * 该方法的作用是生成一个存放中间结果的空的容器，它的返回值是:Supplier<Set<T>>，不传参数，返回一个Set<T>。
     *
     * @return
     */
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet::new;
    }

    /**
     * 该方法的主要作用是进行中间结果的不断累加，看一下它的返回类型BiConsumer<Set<T>, T>，接收两个参数，不返回值，注意一下这两个参数的
     * 顺序：第一个参数为不断增加的结果容器，第二个参数流中遍历的下一个元素，当然就是不断将第二个参数往第一个参数中累加，所以下面先用Lambda
     * 表达式的方式来实现一下。
     *
     * @return
     */
    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (set, item) -> set.add(item);
    }

    /**
     * 而此方法的作用就是将上面两个部分结果进行合并，所以可以这样实现：
     *
     * @return
     */
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    /**
     * 它的作用其实就是将中间累加的结果容器转换成最终的结果，而对于咱们这边的场景其最终结果类型也就是中间结果类型，所以直接将累加的中间结果
     * 容器返回既可
     *
     * @return
     */
    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoked!");
        return t -> t;
    }

    /**
     * 主要是决定收集器的一些特性的，这里返回一个无序特性
     *
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, UNORDERED));
    }

    /**
     * 至此，咱们自定义的收集器就已经定义好啦，接下来咱们来使用一下它，将定义的List转换成Set
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");
        Set<String> collect = list.stream().collect(new MySetCollector<>());
        System.out.println(collect);
    }
}

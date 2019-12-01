package com.study.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优先级队列 PriorityQueue 通过堆实现，具体说是通过完全二叉树（complete binary tree）实现的小顶堆（任意一个非叶子节点的权值，都不大于
 * 其左右子节点的权值），也就意味着可以通过数组来作为 PriorityQueue 的底层实现。
 * @author zcp
 * 2019/12/1 下午5:18
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class PriorityQueueTest {

    /**
     * PriorityQueue 是基于优先堆的一个无界队列，这个优先队列中的元素可以默认自然排序或者通过提供的 Comparator 在队列实例化的时排序。
     * PriorityQueue 不允许空值，而且不支持 non-comparable（不可比较）的对象，比如用户自定义的类。优先队列要求使用 Java Comparable
     * 和 Comparator 接口给对象排序，并且在排序时会按照优先级处理其中的元素。
     * PriorityQueue 的大小是不受限制的，但在创建时可以指定初始大小。当我们向优先队列增加元素的时候，队列大小会自动增加。
     * PriorityQueue 是非线程安全的，所以 Java 提供了 PriorityBlockingQueue（实现 BlockingQueue接口）用于Java 多线程环境。
     * @param args
     */
    public static void main(String[] args) {
        Queue<Integer> queue1 = new PriorityQueue<Integer>();
        queue1.add(2);
        queue1.add(1);
        queue1.add(3);

        while (!queue1.isEmpty()) {
            Integer i = queue1.poll();
            System.out.println(i);
        }

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.id - o2.id);
            }
        };

        Queue<Student> queue2 = new PriorityQueue<Student>(comparator);
        queue2.add(new Student(2, "B"));
        queue2.add(new Student(1, "A"));
        queue2.add(new Student(3, "C"));

        while (!queue2.isEmpty()) {
            Student s = queue2.poll();
            System.out.println(s.toString());
        }
    }

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return id + "-" + name;
        }
    }
}

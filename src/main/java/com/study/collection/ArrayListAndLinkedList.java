package com.study.collection;



import java.util.*;

/**
 * @author zcp
 * @description 数组和链式数据集合的性能比较
 * @Date 2019/11/03
 */
public class ArrayListAndLinkedList {


    /**
     * ArrayList 和 LinkedList 是List接口的连个不同实现，采用了不同的底层数据结构，性能上会产生差异。
     * ArrayList的底层数据结构是数组，这也就使得ArrayList特性上有了数组的的特征，对于数组来说，我们可以通过元素下标很轻松的一次性定位到
     * 元素，因此，这就使得ArrayList在元素的访问上具有大的优势。
     * LinkedList的底层数据结构是双向链表，由于链表以结点作为存储单元，这些存储单元可以是不连续的。每个结点由两部分组成：存储的数值+前序
     * 结点和后序结点的指针，在数据删除的时候，只需要将这个元素的前后指针删除，前一个元素的指针直接指向后一个数据就行，更改的只是指针地址，
     * 并不影响其他，因此，LinkedList在数据插入和删除时具有绝对优势。
     * @param args
     */
    public static void main(String[] args) {
        test(new ArrayList());
        System.out.println();
        test(new LinkedList());
    }

    private static final int REPS = 100;

    //内部抽象类，作为List测试。
    private abstract static class Tester {
        String name;
        int size;

        Tester(String name, int size) {
            this.name = name;
            this.size = size;
        }

        abstract void test(List a);
    }

    //一个测试数组，存储get(随机取)、iteration(顺序遍历)、insert(中间插入)、remove(随机删除)
    private static Tester[] tests = {
            new Tester("get", 300) {
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        for (int j = 0; j < a.size(); j++) {
                            a.get(j);
                        }
                    }
                }
            },
            new Tester("iteration", 3000) {
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        Iterator it = a.iterator();
                        while (it.hasNext()) it.next();
                    }
                }
            },
            new Tester("insert", 10000) {
                void test(List a) {
                    int half = a.size() / 2;
                    String s = "test";
                    ListIterator it = a.listIterator(half);
                    for (int i = 0; i < size * 10; i++) {
                        it.add(s);
                    }
                }
            },
            new Tester("remove", 50000) {
                void test(List a) {
                    ListIterator it = a.listIterator(3);
                    while (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                }
            }
    };

    public static void test(List a) {
        System.out.println("Testing " + a.getClass().getName());//输出测试的类名称
        for (int i = 0; i < tests.length; i++) {
            fill(a, tests[i].size);//填充空集合
            System.out.print(tests[i].name);
            long t1 = System.currentTimeMillis();
            tests[i].test(a);//进行测试
            long t2 = System.currentTimeMillis();
            System.out.print(":" + (t2 - t1) + " ms ");
        }
    }

    public static Collection fill(Collection c, int size) {
        for (int i = 0; i < size; i++) {
            c.add(Integer.toString(i));
        }
        return c;
    }
}

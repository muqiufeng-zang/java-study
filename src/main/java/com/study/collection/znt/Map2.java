package com.study.collection.znt;

import java.util.*;

/**
 * @author  znt
 * @description  各Map实现类的性能分析
 * @Date 2019/11/21
 */
public class Map2 {

    /**
     * Map的常规操作为：put  remove  get  foreach
     */

    public static void main(String[] agrs){

        testmap(new Hashtable<>());
        System.out.println();
        testmap(new HashMap<>());
        System.out.println();
        testmap(new TreeMap<>());
        System.out.println();
        testmap(new LinkedHashMap<>());
        System.out.println();
        testmap(new IdentityHashMap<>());
    }


    public static void testmap(Map<Integer,String> map){
        //利用反射输入测试类的名称
        System.out.println("Map： "+ map.getClass().getName());
        //填充map中的值
        build(map);
        int size = Tester.length;
        for(int i=0;i<size;i++){
            long starTime = System.currentTimeMillis();
            Tester[i].test(map);
            long endTime =System.currentTimeMillis();
            System.out.println(Tester[i].name+ " : "+(endTime-starTime)+"ms  ");
        }
    }

    public static Maps[] Tester= {
            new Maps("put") {
                @Override
                void test(Map<Integer, String> map) {
                    for(int i=0;i<100000;i++) {
                        map.put(100000+i, "add new Object");
                    }
                }
            },
            new Maps("get") {
                @Override
                void test(Map<Integer, String> map) {
                    for(int i=0;i<100000;i++) {
                        map.get(66);
                    }
                }
            },
            new Maps("remove") {
                @Override
                void test(Map<Integer, String> map) {
                    for(int i=0;i<100000;i++) {
                        map.remove(66);
                    }
                }
            },
            new Maps("foreach") {
                @Override
                void test(Map<Integer, String> map) {
                    Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Integer key = iterator.next().getKey();
                        //String value = map.get(iterator.next());
                    }
                }
            }
    };

    public static final int COUNT = 1000;

    public abstract static class Maps{

        String name;
        int size;

        Maps(String name){
            this.name=name;
        }

        Maps(String name,int size){
            this.name=name;
            this.size=size;
        }

        abstract void test(Map<Integer,String> map);

    }

    public static Map<Integer,String> build(Map<Integer,String> map){

            for(int j=0;j<1000;j++) {
                map.put(j, "abc" + j);
            }

        return map;
    }


}

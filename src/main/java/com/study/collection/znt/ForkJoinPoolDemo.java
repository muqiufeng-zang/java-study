package com.study.collection.znt;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author  znt
 * @description  ForkJoinPool
 * @Date 2019/12/01
 */
public class ForkJoinPoolDemo {
    private static final Integer THRESHOLD = 200;

    static class CountTask extends RecursiveTask<Integer>{
        private static final long serialVersionUID = 1L;
        private int start;
        private int end;

        public CountTask(int start,int end){
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute(){
            //防止子任务划分层次太深而造成系统资源耗尽，
            //增加了一个200的阈值，如果计算之和小于200，那就不再进行划分
            if(end - start < THRESHOLD){
                System.out.println("子任务区间达到阈值，开始计算的区间：["+start+","+end+"]");
                Integer sum=0;
                for(int i=start;i<=end;i++){
                    sum += i;
                }
                return sum;
            }else {
                CountTask left = new CountTask(start, (start + end) / 2);
                System.out.println("左半部分子任务，开始计算的区间：[" + start + "," + (start+end)/2 + "]");
                left.fork();
                CountTask right = new CountTask((start + end) / 2 + 1, end);
                System.out.println("右半部分子任务，开始计算的区间：[" + ((start + end) / 2 + 1) + "," + end + "]");
                right.fork();
                return left.join() + right.join();
            }
        }

        /**
         *  采用ForkJoinPool的方式来计算1-1000数字之和，了解该方式的运作机制
         */
        public static void main(String[] args){
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask<Integer> taskFuture = pool.submit(new CountTask(1,1000));
            try{
               // 执行get()时，任务没有结束，那么主线程会在get()时等待
                Integer result = taskFuture.get();
                System.out.println("result = "+result);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

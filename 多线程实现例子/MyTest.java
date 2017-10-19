package com.vcread.supermsg.console;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhanwei on 2017/10/19.
 */
public class MyTest {

    private static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        List<Integer> ll = Lists.newArrayList();
        for (int i=0;i<1000;i++){
            ll.add(i);
            if (ll.size() == 10) {
                System.out.println("ll.size----"+ll.size());
                service.execute(new Task(ll,list));
                ll = Lists.newArrayList();
            }
        }

        if (ll.size() > 0) {
            service.execute(new Task(ll,list));
        }

        service.shutdown();
        while (true) {
            if (service.isTerminated()) {
                System.out.println("结束了！");
                break;
            }
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("list.size="+list.size());
    }

    static class Task implements Runnable {
        private List<Integer> list ;

        private List<Integer> ll;

        public Task(List<Integer> ll,List<Integer> list) {
            this.ll = ll;
            this.list = list;
        }

        @Override
        public void run() {
            for (Integer integer : ll) {
                list.add(integer+1);
            }
        }
    }

}

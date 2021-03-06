package org.tlf.test.containers;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class ContainerNotSafeDemo {
    public static void main(String[] args) {
        notSafe();
//        vectorTest();
//        collectionsTest();
//        copyOnWriteArrayListTest();
    }

    /**
     * 故障现象
     * java.util.ConcurrentModificationException
     */
    public static void notSafe() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }

    public static void vectorTest(){
        List<String> list = new Vector<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }

    /**
     * 解决方案2
     * 使用Collections辅助类
     */
    public static void collectionsTest(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }

    /**
     * 解决方案3
     * CopyOnWriteArrayList
     */
    public static void copyOnWriteArrayListTest(){
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread " + i).start();
        }
    }

}


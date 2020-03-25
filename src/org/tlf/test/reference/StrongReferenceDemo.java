package org.tlf.test.reference;

public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object(); // 强引用
        Object obj2 = obj1;  // obj2引用赋值
        obj1 = null;
        System.gc();
        System.out.println(obj2);
    }
}

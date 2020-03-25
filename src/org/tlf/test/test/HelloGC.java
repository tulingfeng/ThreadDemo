package org.tlf.test.test;

public class HelloGC {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println(totalMemory+"\t"+(totalMemory/(double)1024/1024));
        System.out.println(maxMemory+"\t"+(maxMemory/(double)1024/1024));
        byte[] byteArray = new byte[1024*1024*10];
    }
}

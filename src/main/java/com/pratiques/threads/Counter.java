package com.pratiques.threads;


public class Counter {
    int count = 0;

    public void increment() {
        count = count + 1;
        System.out.println(" --" + count);
    }

    public int getCount() {
        return count;
    }
}


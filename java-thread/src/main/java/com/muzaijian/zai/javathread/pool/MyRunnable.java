package com.muzaijian.zai.javathread.pool;

import java.util.Date;

public class MyRunnable implements Runnable {

    private final String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ", id:" + command + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + ", id:" + command + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}

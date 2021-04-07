package com.company;

public class Toe implements Runnable{
    private Thread tr;

    public Toe() {
        tr = new Thread(this, "Toe");
        tr.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Monitor.class) {
                while (Monitor.monitor != 3) {
                    try {
                        Monitor.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Toe");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Monitor.monitor = 1;
                Monitor.class.notifyAll();
            }
        }
    }

    public Thread getThread(){
        return tr;
    }
}

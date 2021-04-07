package com.company;

public class Tic implements Runnable {
    private Thread tr;
    public Tic() {
        tr = new Thread(this, "Tic");
        tr.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Monitor.class) {
                while (Monitor.monitor != 1) {
                    try {
                        Monitor.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("Tik ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Monitor.monitor = 2;
                Monitor.class.notifyAll();
            }
        }
    }

    public Thread getThread() {
        return tr;
    }
}

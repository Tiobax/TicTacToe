package com.company;

public class Tac implements Runnable {
    private Thread tr;
    public Tac() {
        tr = new Thread(this, "Tac");
        tr.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Monitor.class) {
                while (Monitor.monitor != 2) {
                    try {
                        Monitor.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("Tac ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Monitor.monitor = 3;
                Monitor.class.notifyAll();
            }
        }
    }

    public Thread getThread() {
        return tr;
    }
}

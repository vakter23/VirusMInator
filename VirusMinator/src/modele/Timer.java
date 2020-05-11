package modele;

public class Timer extends Thread {
    Thread thread;
    private final long ms;
    private final boolean option;

    public Timer(Thread thread, long ms, boolean option) {
        this.thread = thread;
        this.ms = ms;
        this.option = option;
    }

    public void run() {
        try {
            Thread.sleep(ms);
            thread.interrupt();
        } catch (InterruptedException e) {
            if (option) {
                thread.interrupt();
            }
        }
    }
}
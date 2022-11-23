public class Stopwatch implements Runnable {
    int i;
    static boolean startStopwath = false;
    public Stopwatch(int i) {
        this.i = i;
    }
    synchronized void countDown(int i) throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
                i++;

                if (i % 5 == 0) {
                    Thread.sleep(1000);
                    System.out.println(i + " !");
                    this.notifyAll();
                    while (!startStopwath) {
                        this.wait();
                    }
                }
                if (i % 7 == 0) {
                    Thread.sleep(1000);
                    System.out.println("прошло 7 секунд");
                    this.notifyAll();
                    while (!startStopwath) {
                        this.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            countDown(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
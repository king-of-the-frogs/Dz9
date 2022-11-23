public class MessageTest implements Runnable {
    int i;


    public MessageTest(int i) {
        this.i = i;
    }

    synchronized void useMessage(int i) throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            if ((i > 0)) {
                System.out.println("Test!");
                System.out.println(i++);
                Stopwatch.startStopwath = true;
                this.notify();
            }
            this.wait();

        }

    }

    @Override
    public void run() {
        try {
            useMessage(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
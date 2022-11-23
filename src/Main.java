public class Main {
    static Integer i = 1;

    public static void main(String[] args) throws InterruptedException {

        synchronized (i) {
            Thread thread = new Thread(new Stopwatch(i), "thread");
            Thread thread1 = new Thread(new MessageTest(i), "thread1");

            thread.start();
            thread1.start();

            thread.join();
            thread1.join();

            thread.interrupt();
            thread1.interrupt();

        }
    }
}

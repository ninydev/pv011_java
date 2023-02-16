package ClassWork.February.Week2.Thursday16;

public class ClassWork1602 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " = started ");

        startStopThread();

        System.out.println(Thread.currentThread().getName() + " = finished ");
    }

    private void startStopThread() {
        MyCounterThread th = new MyCounterThread();
        th.start();

        try {
            Thread.sleep(2000);
            th.interrupt();
        }catch (Exception e){
        }
    }

    private void startStopRunner() {
        MyCounterRunner th = new MyCounterRunner();
        new Thread(th, "Counter").start();

        try {
            Thread.sleep(2000);
            th.disable();
        }catch (Exception e){
        }
    }

    private void startFirstThread() {
        MyFirstThread th = new MyFirstThread("Hello World");
        // th.run();
        th.start();
        try {
            th.join();
        } catch (Exception exception) {

        }
    }

    private void curThread() {
        Thread th = Thread.currentThread();
        System.out.println(th);
    }
}

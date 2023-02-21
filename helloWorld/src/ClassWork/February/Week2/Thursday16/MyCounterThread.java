package ClassWork.February.Week2.Thursday16;

public class MyCounterThread extends Thread {
    private void a(){
        System.out.println("A: " + Thread.currentThread().getName());
    }
    private void b(){
        System.out.println("B: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        int count = 1;
        while (!isInterrupted()) {
            System.out.println("Count: " + count++);
            try {
                Thread.sleep(330);
                this.a();
                this.b();
            }
            catch (InterruptedException e) {
                System.out.println(" Мне сказали остановиться ");
                return;
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

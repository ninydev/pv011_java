package ClassWork.February.Week2.Thursday16;

public class MyCounterRunner implements Runnable {

    //  Переменная - которая говорит - работать ли мне
    private boolean isActive = true;

    public void disable() {
        this.isActive = false;
    }

    @Override
    public void run() {
        int count = 1;
        while (isActive) {
            System.out.println("Count: " + count++);
            try {
                Thread.sleep(330);
            } catch (Exception e) {

            }
        }
    }
}

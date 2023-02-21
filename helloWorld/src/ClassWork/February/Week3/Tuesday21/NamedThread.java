package ClassWork.February.Week3.Tuesday21;

import java.util.concurrent.Semaphore;

public class NamedThread implements Runnable
{
    private Semaphore semaphore;
    private String name;
    public  NamedThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); //  Жду разрешения
            System.out.println(name);
            Thread.sleep(100);
            semaphore.release();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

package ClassWork.February.Week3.Tuesday21;

import java.util.concurrent.Semaphore;

public class CopyNamedThread implements Runnable
{
    private Semaphore semaphore;
    private String name;
    public CopyNamedThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); //  Жду разрешения
            System.out.println("Copy " + name);
            Thread.sleep(50);
            semaphore.release();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

package ClassWork.February.Week2.Thursday16;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MyFirstThread extends Thread
{
    private String name;

    public MyFirstThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " = in class started ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " = in class finished ");
    }
}

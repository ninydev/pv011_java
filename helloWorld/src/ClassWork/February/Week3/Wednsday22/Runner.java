package ClassWork.February.Week3.Wednsday22;

import java.util.Date;

public class Runner implements Runnable
{
    public Runner(String name) {
        this.name = name;
    }
    private String name = "Runner";

    private int minSpeed = 1;
    private int maxSpeed = 10;

    private int deltaStart = 0;

    private Date startDate;
    private Date endDate;


    @Override
    public void run() {
        try {
            Thread.sleep(150);
            System.out.println("Still run: " + name + " " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

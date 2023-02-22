package ClassWork.February.Week3.Tuesday21;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PutThread implements Runnable
{
    private Exchanger<String> exchanger;
    public PutThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1; i++){
            print ();
        }

    }

    public void print () {
        try {
            String message=exchanger.exchange(" ==> $ usd ", 55, TimeUnit.MICROSECONDS);
            System.out.println("In Put: " + message);
        }
        catch (TimeoutException ex) {
            System.out.println("Я прийшов тебе нема");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

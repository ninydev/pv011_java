package ClassWork.February.Week3.Tuesday21;

import java.util.concurrent.Exchanger;

public class SomeKidThread implements Runnable
{
    private Exchanger<String> exchanger;
    private String thing;
    public SomeKidThread(Exchanger<String> exchanger, String thing) {
        this.thing = thing;
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
            String message=exchanger.exchange(" " + thing);
            System.out.println(thing + " ==>  " + message);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

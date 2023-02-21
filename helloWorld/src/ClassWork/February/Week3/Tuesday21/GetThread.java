package ClassWork.February.Week3.Tuesday21;

import java.util.concurrent.Exchanger;

public class GetThread implements Runnable {

    private Exchanger<String> exchanger;
    public GetThread(Exchanger<String> exchanger) {
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
            String message=exchanger.exchange(" uah  ==> ");
            System.out.println("In Get: " + message);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

package ClassWork.February.Week3.Tuesday21;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class ClassWork2102 implements Runnable {
    @Override
    public void run() {
        sem();
    }

    private void sem() {
        Random rd = new Random();
        ArrayList<NamedThread> threads = new ArrayList<>();
        Semaphore sem = new Semaphore(32);
        for (int i = 0; i < 50000000; i++) {
            threads.add(new NamedThread(sem," Thread " + i));
        }
        for (int i = 0; i < 50000000; i++) {
            new Thread(threads.get(i)).start();
            if (rd.nextBoolean()) {
                new Thread( new CopyNamedThread(sem, " Copy of " + i)).start();
            }

        }

    }

    private void kids(){
        Exchanger<String> exchanger = new Exchanger<>();
        SomeKidThread p = new SomeKidThread(exchanger, " Мяч ");
        SomeKidThread k = new SomeKidThread(exchanger, " Велик ");
        SomeKidThread m = new SomeKidThread(exchanger, " Пистолет ");
        SomeKidThread a = new SomeKidThread(exchanger, " телефон ");
        SomeKidThread t = new SomeKidThread(exchanger, " может повезет ");

        new Thread(p).start();
        new Thread(k).start();
        new Thread(m).start();
        new Thread(a).start();
        new Thread(t).start();
    }

    private void exchange() {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new GetThread(exchanger)).start();
        new Thread(new PutThread(exchanger)).start();
        new Thread(new PutThread(exchanger)).start();
        new Thread(new PutThread(exchanger)).start();
    }
}

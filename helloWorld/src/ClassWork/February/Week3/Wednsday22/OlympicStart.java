package ClassWork.February.Week3.Wednsday22;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class OlympicStart implements Runnable
{
    private int runnerCount = 10;
    private Thread mainThread;

    private ArrayList<Runner> runners = new ArrayList<>();
    private ExecutorService executorService;

    public OlympicStart(
            ArrayList<Runner> runners,
            int runnerCount,
            ExecutorService executorService
    ){
        this.executorService = executorService;
        this.runnerCount = runnerCount;
        this.runners = runners;
    }

    @Override
    public void run() {
        // Создатьк учу мусора
        System.out.println("Add " + runners.size() + " In Thread " + Thread.currentThread().getName());
        if (runnerCount > runners.size()) {
            Runner runner = new Runner("runner " + runners.size());
            runners.add(runner);
            executorService.submit(runner);
//            executorService.execute(runner);
//            Thread thread = new Thread(runner);
//            thread.start();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // new Thread(this).start();
            this.run();
        }
        // System.out.println("Finish");
    }
}

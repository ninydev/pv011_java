package ClassWork.February.Week3.Wednsday22;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Olympic implements Runnable
{
    private int distension = 100;
    private int runnerCount = 10;

    ArrayList<Runner> runners = new ArrayList<>();

    ExecutorService executorService;

    void shutdownAndAwaitTermination(ExecutorService executorService) throws InterruptedException {

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ie) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


    @Override
    public void run() {
        executorService = Executors.newCachedThreadPool();
        // executorService = Executors.newFixedThreadPool(5);
        OlympicStart doStart = new OlympicStart(
                runners, runnerCount,
                executorService
        );
        // new Thread(doStart).start();
        doStart.run();
        System.out.println("Wait on finish");

        try {
            shutdownAndAwaitTermination(executorService);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

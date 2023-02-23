package ClassWork.February.Week3.Wednsday22;

public class ClassWork2202 implements Runnable
{

    @Override
    public void run() {
        Olympic o = new Olympic();
        o.run();

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(" ===== Program  finish  ===== ");
    }
}

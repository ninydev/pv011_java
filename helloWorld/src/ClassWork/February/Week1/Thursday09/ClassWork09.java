package ClassWork.February.Week1.Thursday09;

public class ClassWork09  implements Runnable
{

    public void makeErr() throws Exception {
        throw new Exception("My Err");
    }

    public void callErr() {
        try {
            makeErr();
        } catch (Exception e) {

        }
    }


    @Override
    public void run() {
//        var WGroup = new WorkPlace();
//        WGroup.name = "WGroup";
//        WGroup.working = new Program();
//
//        var ItStep = new WorkPlace();
//        ItStep.name = "ItStep";
//        ItStep.working = new Teaching();
//
//        var Nykytin = new Human();
//        Nykytin.name = "Sasha";
//
//        Nykytin.run();
//
//        ItStep.BecomeWork(Nykytin);
//        Nykytin.run();
//
//        WGroup.BecomeWork(Nykytin);
//        Nykytin.run();



    }
}

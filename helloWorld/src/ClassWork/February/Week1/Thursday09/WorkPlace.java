package ClassWork.February.Week1.Thursday09;

import ClassWork.February.Week1.Thursday09.Works.DoWork;

public class WorkPlace {
    public String name;
    DoWork working;

    public void BecomeWork (Human h) {
        h.working = working;
    }
}

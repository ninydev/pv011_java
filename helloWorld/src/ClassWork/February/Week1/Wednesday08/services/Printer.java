package ClassWork.February.Week1.Wednesday08.services;

import ClassWork.February.Week1.Wednesday08.models.interfaces.Printable;
import ClassWork.February.Week1.Wednesday08.services.interfaces.Outputer;

public class Printer implements Outputer
{
    @Override
    public void output(Printable obj) {
        System.out.println("Start printing");
        System.out.println(obj);
    }
}

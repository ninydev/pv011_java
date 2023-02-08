package ClassWork.February.Wednesday08.services;

import ClassWork.February.Wednesday08.services.interfaces.Outputer;

public class Printer implements Outputer
{
    @Override
    public void output(Object obj) {
        System.out.println("Start printing");
        System.out.println(obj);
    }
}

package ClassWork.February.Week1.Wednesday08;

import ClassWork.February.Week1.Wednesday08.models.*;
import ClassWork.February.Week1.Wednesday08.services.Office;
import ClassWork.February.Week1.Wednesday08.services.Printer;

public class ClassWork08 implements Runnable
{

    @Override
    public void run() {
        printInOffice();
    }

    private void printInOffice(){

        var myOffice = new Office(
                new Printer()
        );
        myOffice.outAll();

    }

    private void printMany() {
        var p = new Person();
        var a = new Animal();

        var printer = new Printer();
        printer.output(p);
        printer.output(a);

//        printer.output("String");
//        printer.output(1);

//        int i = 10;
//        String s = "Hello";
//        printer.output(i);
//        printer.output(s);

    }
}

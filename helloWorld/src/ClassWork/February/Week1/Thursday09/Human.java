package ClassWork.February.Week1.Thursday09;

import ClassWork.February.Week1.Thursday09.Works.DoWork;

public class Human implements Runnable
{
    public String name;
    DoWork working;


    @Override
    public void run() {
        try {
            working.doWork();
        } catch (Exception e) {
            System.out.println("Я не работаю вне рабочего места");
        }
    }
}

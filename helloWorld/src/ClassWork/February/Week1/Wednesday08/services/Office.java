package ClassWork.February.Week1.Wednesday08.services;

import ClassWork.February.Week1.Wednesday08.models.Animal;
import ClassWork.February.Week1.Wednesday08.models.Person;
import ClassWork.February.Week1.Wednesday08.services.interfaces.Outputer;

public class Office {
    private final Outputer outer;

    public Office(Outputer outer) {
        this.outer = outer;
    }

    public void outAll() {
        var p = new Person();
        var a = new Animal();

        outer.output(p);
        outer.output(a);
    }
}

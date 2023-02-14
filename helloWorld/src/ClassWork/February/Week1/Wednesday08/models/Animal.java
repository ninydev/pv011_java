package ClassWork.February.Week1.Wednesday08.models;

import ClassWork.February.Week1.Wednesday08.models.interfaces.Printable;
import ClassWork.February.Week1.Wednesday08.models.interfaces.Storable;

public class Animal extends BaseModel implements Printable, Storable {


    public int someFun() {
        return super.someFun();
    }
}

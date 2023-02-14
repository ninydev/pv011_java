package ClassWork.February.Week2.Tuesday14.Decorators;

import ClassWork.February.Week2.Tuesday14.Entity.Interface.IOldThings;

public class ObjectToOldThingsDecorator implements IOldThings {

    private Object obj;

    public ObjectToOldThingsDecorator(Object obj ) {
        this.obj = obj;
    }

    @Override
    public int getAge() {
        return 0;
    }
}

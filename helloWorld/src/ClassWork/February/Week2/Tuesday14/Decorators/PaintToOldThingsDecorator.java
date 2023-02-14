package ClassWork.February.Week2.Tuesday14.Decorators;

import ClassWork.February.Week2.Tuesday14.Entity.Interface.IOldThings;
import ClassWork.February.Week2.Tuesday14.Entity.Interface.IPainting;

public class PaintToOldThingsDecorator implements IPainting, IOldThings {

    private IPainting paint;

    public PaintToOldThingsDecorator(IPainting paint) {
        this.paint = paint;
    }
    @Override
    public int getAge() {
        // Не реализованный метод - отдает что мне нужно
        // Загрушка
        return 0;
    }

    @Override
    public String getAuthor() {
        return paint.getAuthor();
    }
}

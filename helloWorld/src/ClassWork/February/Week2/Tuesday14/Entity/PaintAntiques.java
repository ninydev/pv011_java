package ClassWork.February.Week2.Tuesday14.Entity;

import ClassWork.February.Week2.Tuesday14.Entity.Interface.IOldThings;
import ClassWork.February.Week2.Tuesday14.Entity.Interface.IPainting;

public class PaintAntiques extends BaseThing implements IPainting, IOldThings
{
    public PaintAntiques(String name) {
        super(name);
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getAuthor() {
        return null;
    }
}

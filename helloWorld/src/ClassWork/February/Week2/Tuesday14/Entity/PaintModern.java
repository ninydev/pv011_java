package ClassWork.February.Week2.Tuesday14.Entity;

import ClassWork.February.Week2.Tuesday14.Entity.Interface.IPainting;

public class PaintModern extends BaseThing implements IPainting
{
    public PaintModern(String name) {
        super(name);
    }

    @Override
    public String getAuthor() {
        return null;
    }
}

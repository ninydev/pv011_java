package ClassWork.February.Week1.Wednesday08.services.interfaces;

import ClassWork.February.Week1.Wednesday08.models.BaseModel;
import ClassWork.February.Week1.Wednesday08.models.interfaces.Storable;

public interface Keeperable <TEntity extends BaseModel & Storable>
{
    public void push(TEntity entity);
    public TEntity pop();


}

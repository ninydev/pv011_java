package ClassWork.February.Wednesday08.services.interfaces;

public interface Findable<TypeEntity, TypeId> {
    public TypeEntity getById(TypeId id);
}

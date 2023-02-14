package ClassWork.February.Week1.Wednesday08.services.interfaces;

import ClassWork.February.Week1.Wednesday08.models.interfaces.Printable;

/**
 * Необходимо реализовать метод для вывода информации куда либо
 */
public interface Outputer {

    /**
     * Реализация вывода куда либо переданного объекта
     * @param obj
     */
    public void output(Printable obj);
}

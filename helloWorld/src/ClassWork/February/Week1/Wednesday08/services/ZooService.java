package ClassWork.February.Week1.Wednesday08.services;

import ClassWork.February.Week1.Wednesday08.models.Animal;
import ClassWork.February.Week1.Wednesday08.services.interfaces.*;

import java.util.Stack;

public class ZooService
        implements Findable<Animal, Integer>,
        Keeperable<Animal>,
        DBStorable,
        FileStorable
{


    @Override
    public Animal getById(Integer i) {
        return items.get(i);
    }

    Stack<Animal> items;

    @Override
    public void push(Animal animal) {
        items.push(animal);
    }

    @Override
    public Animal pop() {
        return items.pop();
    }

    @Override
    public void saveAll() {

    }

    @Override
    public void saveAll(String fileName) {

    }
}

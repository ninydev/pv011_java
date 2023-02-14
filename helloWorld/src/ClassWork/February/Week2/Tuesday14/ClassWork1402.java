package ClassWork.February.Week2.Tuesday14;

import ClassWork.February.Week2.Tuesday14.Decorators.ObjectToOldThingsDecorator;
import ClassWork.February.Week2.Tuesday14.Decorators.PaintToOldThingsDecorator;
import ClassWork.February.Week2.Tuesday14.Entity.BaseThing;
import ClassWork.February.Week2.Tuesday14.Entity.Interface.IOldThings;
import ClassWork.February.Week2.Tuesday14.Entity.Interface.IPainting;
import ClassWork.February.Week2.Tuesday14.Entity.PaintAntiques;
import ClassWork.February.Week2.Tuesday14.Entity.PaintModern;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ClassWork1402 implements Runnable
{

    @Override
    public void run() {
        standartCollectionHashSet();
    }

    private void standartCollectionHashSet() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Vasya1");
        hashSet.add("Petya11");
        hashSet.add("Petya11");
        hashSet.add("Sasha");
        hashSet.add("Alex");
        hashSet.add("Sasha");

        for (String n: hashSet) {
            System.out.println(n);
        }
    }

    private void standartCollectionLinkedList() {

        ArrayDeque<String> arrDeque = new ArrayDeque<>();
        arrDeque.add("Vasya1");
        arrDeque.add("Petya11");
        arrDeque.add("Sasha");
        arrDeque.add("Alex");

        LinkedList<String> linkedList = new LinkedList<>(arrDeque);
        linkedList.add("Vasya1");
        linkedList.add("Petya11");
        linkedList.add("Sasha");
        linkedList.add("Alex");

        for (String n: linkedList) {
            System.out.println(n);
        }
    }

    private void standartCollectionsArrayDeque() {
        ArrayDeque<String> arrDeque = new ArrayDeque<>();
        arrDeque.add("Vasya1");
        arrDeque.add("Petya11");
        arrDeque.add("Sasha");
        arrDeque.add("Alex");

        for (String n: arrDeque) {
            System.out.println(n);
        }
        System.out.println("Size " + arrDeque.size());
    }



    private void standartCollectionsArrayList(){
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("Vasya1");
        arrList.add("Petya11");
        arrList.add("Sasha");
        arrList.add("Alex");

        System.out.println("Before sort");
        for (String n: arrList) {
            System.out.println(n);
        }

        var c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // System.out.println("Sort " + o1.length());
                if(o1.length() > o2.length())
                    return 1;
                else
                    return -1;
            }
        };

        arrList.sort(c);
        // arrList.sort((s1, s2) -> s1.length() - s2.length() );

        System.out.println("\n\nAfter sort");
        for (String n: arrList) {
            System.out.println(n);
        }

    }

    private void createMyCollection() {
        var col = new Collection<BaseThing>() {

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NotNull
            @Override
            public Iterator<BaseThing> iterator() {
                return null;
            }

            @NotNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NotNull
            @Override
            public <T> T[] toArray(@NotNull T[] a) {
                return null;
            }

            @Override
            public boolean add(BaseThing baseThing) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NotNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NotNull Collection<? extends BaseThing> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NotNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NotNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }

    private void myCollections() {
        var myPict = new PaintModern(" Моя картина");
        var myDali = new PaintAntiques(" Картина Cальвадора Дали");

        // Единый предок
        var colArrBaseThing = new ArrayList<BaseThing>();
        colArrBaseThing.add(myPict);
        colArrBaseThing.add(myDali);

        // Единый интерфейс
        var colArrPaint = new ArrayList<IPainting>();
        colArrPaint.add(myPict);
        colArrPaint.add(myDali);

        for (IPainting el: colArrPaint) {
            el.getAuthor();
            if(el instanceof BaseThing test) {
                test.getName();
                ((BaseThing) el).getName();
            }
        }

        var colAnti = new ArrayList<IOldThings>();
        colAnti.add(myDali);
        colAnti.add(new ObjectToOldThingsDecorator(myPict));
        colAnti.add(new PaintToOldThingsDecorator(myPict));










    }

}

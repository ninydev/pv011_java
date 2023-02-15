package ClassWork.February.Week2.Wednesday15;

import ClassWork.February.Week2.Wednesday15.Calculator.OperationableInt;
import ClassWork.February.Week2.Wednesday15.Lib.UserModel;
import ClassWork.February.Week2.Wednesday15.Lib.UserPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ClassWork1502 implements Runnable
{

    @Override
    public void run() {
        objectStream();
    }

    private void objectStream() {
        ArrayList<UserModel> dbUsers = new ArrayList<>();
        dbUsers.add( new UserModel("keeper@ninydev.com", "1q2w3e"));
        dbUsers.add( new UserModel("nika_web@ukr.net", "1q2w3e"));

        dbUsers.stream().forEach( u -> {
            System.out.println(u);
        });

        Function <UserModel, UserPresenter> mapper;
        mapper = u -> new UserPresenter(u);
        // mapper = UserPresenter::new;

        Stream<UserPresenter> outUsers = dbUsers.stream().map(mapper);

        outUsers.forEach( u -> {
            System.out.println(u);
        });

 }



    private void simpleStream() {
        /**
         * arr - массив
         * col - коллекция
         */
        int [] arr = {-5,5,33,4,5,12,-50};
        ArrayList<Integer> col= new ArrayList<>();
        for (int i: arr) {col.add(i);}

        try {
            IntStream intStream = IntStream.of(arr);
            // Вернет промежуточное значние - другой поток
            // intermediate
            intStream = intStream.filter(el-> el > 0);

            // Вернет окончательное значени
            // terminal
            // long cArr = intStream.count();
            // System.out.println(cArr);
            // boolean isAny = intStream.anyMatch(el-> el < 0);

            LongStream longStream = intStream.mapToLong(value -> value );

            // Второе обращение к потоку вызывает ошибку - поскольку до этого
            // была терминирующая функция
            // long sArr = intStream.count();
        } catch (Exception exception) {
            System.out.println("Err: " + exception.getMessage());
        }





    }

    private void StandartLambda(){
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> test = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        };
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return null;
            }
        };
        UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return null;
            }
        };
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return null;
            }
        };
        BiFunction<Integer, String, Float> biFunction = new BiFunction<Integer, String, Float>() {
            @Override
            public Float apply(Integer integer, String s) {
                return null;
            }
        };
        Consumer<Integer> consumer =  new Consumer<>() {

            @Override
            public void accept(Integer integer) {

            }
        };
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return null;
            }
        };
    }

    private void doCalc(){
        OperationableInt plus = new OperationableInt() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }

            public void print(int a, int b) {
                System.out.println(a + " + " + b);
            }
        };

        System.out.println(plus.calc(2,2));

        OperationableInt minus;
        minus = (a,b) -> a - b;
        System.out.println(minus.calc(3, 1));

    }
}

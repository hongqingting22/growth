package com.lxl.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaOne {

    public static List<Person> persons = new ArrayList<Person>();
    {
        for(int i = 1;i<8;i++){
            persons.add(new Person("小人物"+i, 20+i));
        }

    }
    @Test
    public void test1(){
        System.out.println("------sort-----------------");
        persons.sort((x, y) -> {
            return x.getAge() - y.getAge();
        });
        persons.forEach(person ->{
            System.out.print(person + "  ");
        });
        System.out.println();
        System.out.println("----------filter--------------");
        persons.stream()
                .filter(e -> e.getAge() > 24)
                .collect(Collectors.toList())
                .forEach(person ->{
                    System.out.print(person + "  ");
                });
        System.out.println();
        System.out.println("------------map------------");
        persons.stream()
                .map(Person::getAge)
                .collect(Collectors.toList())
                .forEach(a -> {
                    System.out.print(a + "  ");
                });
        System.out.println();
        System.out.println("----------distinct  count--------------");
        persons.add(new Person("小人物1",21));
        persons.stream().distinct().forEach(person ->{
            System.out.print(person + "  ");
        });
        System.out.println();
        System.out.println(persons.stream().count());
        System.out.println("--------predicate(自定义filter)----------------");
        getPersonByPredicate(person -> person.getAge()>22 && person.getName().contains("3"))
                .forEach(System.out::println);
        System.out.println("----------自定义函数式接口--------------");
        MyInteface my = (a,b)->{return a +b ;};
        System.out.println("sum:"+my.sum(2,4));
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");
    }

    public List<Person> getPersonByPredicate(Predicate<Person> predicate){
        return persons.stream().filter(predicate).collect(Collectors.toList());
    }

    interface MyInteface{
        int sum(int a,int b);
    }

    /**
     * 线程lambda
     */
    @Test
    public void test2(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();

        new Thread(()->System.out.println("hello")).start();

        System.out.println("-------------------------");
        System.out.println(getStr(e -> e +"啦啦啦啦", 3));

    }

    public String getStr(Function<Integer,String> function, Integer arg){
        return function.apply(arg);
    }


}

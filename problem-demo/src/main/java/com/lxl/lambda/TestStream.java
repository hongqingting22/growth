package com.lxl.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * stream 流式编程
 * stream-为集合创建串行流
 * parallelStream-为集合创建并行流
 *
 * 中间操作：
 * map (mapToInt,flatMap)
 * filter
 * distinct-- 对象去重，需要重写equals和hashCode方法
 * sorted--区别于sort，sort不是流式编程的操作，sort使用thenCompare执行多字段排序；
 *          sorted叠加使用，以从后往前的顺序为排序优先级
 * peek
 * limit--限制返回个数
 * skip
 * parallel
 * sequential
 * unordered
 *
 * 终止操作：
 * forEach
 * forEachOrdered
 * toArray
 * reduce
 * collect
 * min
 * max
 * count
 * anyMatch
 * allMatch
 * noneMatch
 * findFirst
 * findAny
 * iterator
 */
public class TestStream {

    public static List<Person> persons = new ArrayList<Person>();
    {
        for(int i = 1;i<8;i++){
            persons.add(new Person("小人物"+i, 20+(10-i)));
        }

    }
    @Test
    public void test1(){
        System.out.println("------sort-----------------");
        persons.sort((x, y) -> {
            return x.getAge() - y.getAge();
        });
        persons.forEach(System.out::print);
        System.out.println();
        persons.add(new Person("小人物10",25));
        persons.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName));
        persons.forEach(System.out::print);
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
        persons.parallelStream()
                .map(Person::getAge)
                .collect(Collectors.toList())
                .forEach(a -> {
                    System.out.print(a + "  ");
                });
        System.out.println();
        System.out.println("------------age+1-----------------");
        persons.parallelStream()
                .map(person -> person.getAge() +1)
                .collect(Collectors.toList())
                .forEach(a -> {
                    System.out.print(a + "  ");
                });
        System.out.println("-----------person.age + 1-----------------------");
        persons.forEach(person -> {
            person.setAge(person.getAge()+1);
        });
        persons.forEach(System.out::print);
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
        System.out.println("-----------limit-------------");
        persons.stream().limit(3).forEach(System.out::print);
        System.out.println();
        System.out.println("------------skip------------");
        persons.stream().skip(2).forEach(System.out::print);
        System.out.println();
        System.out.println("-----------reduce-------------");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(nums.stream().reduce((a,b)->a+b).get());
        System.out.println("-------------min  max-----------");
        System.out.println(persons.stream()
                .max((p1,p2)->Integer.compare(p1.getAge(),p2.getAge())).get());

        System.out.println(persons.stream().min(Comparator.comparing(Person::getAge)).get());
        System.out.println("------------match------------");
        boolean anyMatch = persons.stream().anyMatch(person -> person.getName().equals("小人物20"));
        System.out.println("是否有名字是“小人物20”的人："+anyMatch);
        boolean allMatch = persons.stream().allMatch(person -> person.getAge() > 18);
        System.out.println("是否所有同学的年龄都大于18："+allMatch);
        boolean noneMatch = persons.stream().noneMatch(person -> person.getName().equals("小人物20"));
        System.out.println("是不是没有人叫“小人物20”"+noneMatch);
        System.out.println("-----------------sorted-------------------------");
        persons.stream().sorted(Comparator.comparing(Person::getAge))
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();
        System.out.println("----------------find-------------------------");
        System.out.println(persons.stream().findFirst().get());
        System.out.println(persons.stream().findAny().get());
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

        MyInteface my = (a,b) ->{return a + b;};
        int sum = my.sum(2, 3);
        System.out.println(sum);

    }

    public String getStr(Function<Integer,String> function, Integer arg){
        return function.apply(arg);
    }


}

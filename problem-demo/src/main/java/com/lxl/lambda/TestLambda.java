package com.lxl.lambda;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 三种编写方式
 * 1.expression:单条语句表达式
 * 2.statement:语句块
 * 3.reference:方法引用
 *      1.实例方法引用   Person::getName
 *      2.构造方法呢引用  Person::new
 *      3.基于参数实例的实例方法引用
 *      4.静态方法引用
 */
public class TestLambda {

    @Test
    public void test1(){

        MyFunction my = ()->{
            System.out.println("hello!");
        };
        my.sayHello();
    }

    /**
     * 实例方法引用
     */
    @Test
    public  void test2(){
        ReferenceTest test = new ReferenceTest();
        Function<String, String> sayHello = test::sayHello;
        String lily = sayHello.apply("lily");
        System.out.println(lily);
    }

    @Test
    public  void test3(){
        Supplier<ReferenceTest> aNew = ReferenceTest::new;
        ReferenceTest o = aNew.get();
        o.sayHello("lily");

    /*    BiConsumer<Person, Integer> setAge = Person::setAge;
        setAge.accept();*/

        BiFunction<String, Integer, Integer> stringIntegerIntegerBiFunction = Integer::valueOf;
        Integer name = stringIntegerIntegerBiFunction.apply("18", 20);
        System.out.println(name);

    }
}


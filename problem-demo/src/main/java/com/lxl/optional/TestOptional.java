package com.lxl.optional;

import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(18);
        Person person3 = Optional.ofNullable(person).orElseThrow(() -> new RuntimeException("null"));
        System.out.println(person3);

        Person person1 = Optional.of(person).get();
        System.out.println(person1);
       Optional.ofNullable(person).ifPresent(p -> System.out.println(p.getAge()));

        Person person2 = Optional.ofNullable(person).filter(p -> p.getAge() > 10).get();
        System.out.println(person2);

        String value = "11";
        String s = Optional.ofNullable(value).get();
        System.out.println("====="+s);
    }
}

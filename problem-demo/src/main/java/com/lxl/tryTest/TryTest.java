package com.lxl.tryTest;

import java.util.ArrayList;
import java.util.List;

/**
 * try catch finally return
 * 1.正常执行try，异常执行catch，最终都要执行finally
 * 2.当try块有return，finally块无return，代码最后有return时
 *      基本数据类型：try块中return的值会被放在栈中，执行finally，可以修改变量值，但是不会改变return的结果
 *      引用数据类型：try块中return的引用类型会被存在栈中，执行finally，修改了引用类型的值，则return的值为修改后的值
 * 3.当try块有return，finally中也有return时
 *      try块return会被保存，但是执行finally时，会将之前保存的覆盖掉
 * 4.当try块，catch块有return，finally里没有return时
 *      try块return会被保存，finally里如果有执行修改的操作，会影响返回的值
 *
 * 5.try块和catch块都有return时，方法结尾不能加return，执行不到编译出错
 * 6.执行顺序：try 保存return数据 finally 真正的返回数据
 */
public class TryTest {

    public static int test(int temp){
        int n = 0;
        try {
            n = 10 /temp;
            System.out.println("in-------------" + n);
            return n;
        } catch (Exception e) {
            n++;
            e.printStackTrace();
            System.out.println("exception-------" + n);
        } finally {
            n++;
            System.out.println("finally_------------" + n);
        }
        return n;
    }

    public static void main(String[] args) {
        int test = test(1);
        System.out.println(test);

        int test1 = test1();
        System.out.println(test1);

        List<Integer> test2 = test2();
        System.out.println(test2);

        RetDto dto = test3();
        System.out.println(dto);
    }

    private static int test1() {
         int i = 1;
         try {
             i++;
             System.out.println("try:" + i);
             return i;
         } catch (Exception e) {
            i++;
             System.out.println("catch:" + i);
         } finally {
             i++;
             System.out.println("finally:" + i);
             return i;
         }
     }

    private static List<Integer> test2() {
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            System.out.println("catch:" + list);
        } finally {
            list.add(2);
            System.out.println("finally:" + list);
        }
        return list;
    }

    private static RetDto test3() {
        RetDto dto = new RetDto();
        try {
            dto.name = "try";
            dto.age = 1;
            System.out.println("try:" + dto);
            return dto;
        } catch (Exception e) {
            System.out.println("catch:" + dto);
            return dto;
        } finally {
            dto.name = "finally";
            dto.age = 19;
            System.out.println("finally:" + dto);
        }
//        return dto;
    }

   static class RetDto{
        String name;
        int age;

        @Override
        public String toString() {
            return "RetDto{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

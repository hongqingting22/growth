package com.lxl.lambda;

@FunctionalInterface
public interface MyFunction {
    /**
     * 函数式接口
     * 1.注解@FunctionInterface,（不添加该注解，满足只有一个抽象方法的接口也会被识别为函数式接口）
     * 2.接口中只有一个抽象方法
     * 3.接口中的Object重写方法不影响
     */

    void sayHello();
    String toString();

    /**
     * default方法为默认方法，可存在接口中，有实现
     */
    default void test(){}
}

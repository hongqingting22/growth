package com.lxl.lambda;

@FunctionalInterface
public interface MyFunction {
    /**
     * 函数式接口
     * 1.注解@FunctionInterface
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

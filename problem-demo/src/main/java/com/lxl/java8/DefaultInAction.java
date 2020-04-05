package com.lxl.java8;

/**
 * 默认方法
 *      接口中可以定义默认方法，不影响之前已经实现该接口类
 *      实现类中也可以重写默认方法
 *  多继承处理原则：
 *      1.class优先级最高 -- 实现类中重写了接口的方法，则按照重写的逻辑执行
 *      2.直接继承 -- 如：C类实现了B接口和A接口，B接口继承了A接口，则B为C类的直接继承
 *      3.实现类可以显示的调用多个实现接口中的默认方法
 *          如：A,B两个接口，都有默认方法hello，C类继承了A,B，
 *              则可以显式调用A.super.hello()或B.super.hello()
 */
public class DefaultInAction {



 /*
    默认方法
   interface DefaultA{
        int size();
        default boolean isEmpty(){
            return size() == 0;
        }
    }

    public static void main(String[] args) {
        DefaultA defaultA = () -> 10;
        System.out.println(defaultA.size());
        System.out.println(defaultA.isEmpty());
    }*/

    interface A{
        default void hello(){
            System.out.println("A hello");
        }
    }
    interface B extends A{
        @Override
        default void hello() {
            System.out.println("B hello");
        }
    }

    class C implements B,A{
        @Override
        public void hello() {
//            A.super.hello(); 如果B没有继承A，则可以
        }
    }

    public static void main(String[] args) {
       DefaultInAction action = new DefaultInAction();
        C c = action.new C();
        c.hello();
    }
}

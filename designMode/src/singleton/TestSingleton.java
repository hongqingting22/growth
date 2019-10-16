package singleton;

public class TestSingleton {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        System.out.println(instance == instance1);

    }

    /**
     * jdk中java.lang.Runtime类使用的是饿汉式
     */
}

package singleton;

/**
 * 加载SingleTon类时不会加载静态内部类，可以满足延迟加载
 * 调用getInstance方法时，jvm第一次加载静态内部类，同时初始化静态变量instance，保证是安全的
 */
public class InnerClassSingleton {
    private InnerClassSingleton(){}

    private static class InnerClassSingletonHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return InnerClassSingletonHolder.instance;
    }
}

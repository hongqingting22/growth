package singleton;

public class InnerClassSingleton {
    private InnerClassSingleton(){}

    private static class InnerClassSingletonHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return InnerClassSingletonHolder.instance;
    }
}

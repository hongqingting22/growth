package singleton;

/**
 * 实现了延迟加载，但是多线程时仍然可能创建多个对象，不安全
 */
public class LazySingleton {
    public LazySingleton instance = null;

    private LazySingleton(){
    }

    public LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

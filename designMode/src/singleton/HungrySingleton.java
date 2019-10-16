package singleton;

/**
 * 缺点：内存消耗，不能延迟加载
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){
    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}

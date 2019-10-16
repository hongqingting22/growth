package singleton;

/**
 * 双重校验
 */
public class DoubleCheckSingleton {
    public volatile static DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton(){
    }

    public static DoubleCheckSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}

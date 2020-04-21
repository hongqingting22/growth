package singleton;

/**
 * 双重校验
 * 不加volatile，可能会出现获取值为空的情况
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

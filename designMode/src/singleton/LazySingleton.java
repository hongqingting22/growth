package singleton;

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

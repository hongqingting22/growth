package singleton;

/**
 * 单元素枚举实现单例
 * 1.其他单例能被反射攻击
 * Constructor<Singleton> constructor=Singleton.class.getDeclaredConstructor();
 *          constructor.setAccessible(true);
 * 2.其他单例序列化后会产生新对象
 * ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerSingleton.obj"));
 * oos.writeObject(s);
 *
 * FileInputStream fis = new FileInputStream("SerSingleton.obj");
 *  ObjectInputStream ois = new ObjectInputStream(fis);
 *  SerSingleton s1 = (SerSingleton)ois.readObject();
 */
public enum EnumSingleton {
    INSTANCE;

    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}

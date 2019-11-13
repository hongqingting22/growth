package simpleVersion.create.simpleFactory;

public class Client {


    public static void main(String[] args) {
        Food food = null;
        food = StaticFactory.getFood("fruit");

        //多个静态方法实现
        food = StaticFactory.getFruit();
    }
}

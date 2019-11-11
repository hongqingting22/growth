package simpleVersion.simpleFactory;

public class Client {


    public static void main(String[] args) {
        Food food = null;
        food = StaticFactory.getFood(args[0]);
    }
}

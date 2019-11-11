package simpleVersion.simpleFactory;

public class StaticFactory {
    private StaticFactory(){}

    public static Food getFood(String name){
        if(name.equals("Fruit")){
            return new Fruit();
        }else if(name.equals("Rice")){
            return new Rice();
        }
        return null;
    }
}

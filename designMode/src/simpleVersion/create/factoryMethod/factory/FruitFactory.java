package simpleVersion.create.factoryMethod.factory;


import simpleVersion.create.factoryMethod.Food;
import simpleVersion.create.factoryMethod.Fruit;

public class FruitFactory implements Factory {

    @Override
    public Food produce() {
        return new Fruit();
    }
}

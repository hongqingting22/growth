package simpleVersion.create.factoryMethod.factory;

import simpleVersion.create.factoryMethod.Food;
import simpleVersion.create.factoryMethod.Rice;

public class RiceFactory implements Factory {
    @Override
    public Food produce() {
        return new Rice();
    }
}

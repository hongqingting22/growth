package simpleVersion.create.factoryMethod;

import simpleVersion.create.factoryMethod.factory.Factory;
import simpleVersion.create.factoryMethod.factory.RiceFactory;

public class Client {
    public static void main(String[] args) {
        /**
         * 工厂方法模式
         */
//        Factory factory = new FruitFactory();
        Factory factory = new RiceFactory();
        Food produce = factory.produce();
        produce.make();
    }
}

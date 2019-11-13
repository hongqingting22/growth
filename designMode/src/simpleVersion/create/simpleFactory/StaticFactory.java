package simpleVersion.create.simpleFactory;

/**
 * 简单工厂模式
 * 三种实现：
 * 1.静态方法，if-else实现
 * 2.多个方法
 * 3.多个静态方法
 */
public class StaticFactory {
    private StaticFactory(){}

    /**
     * 简单工厂1-静态方法  if-else实现
     * @param name
     * @return
     */
    public static Food getFood(String name){
        if(name.equals("Fruit")){
            return new Fruit();
        }else if(name.equals("Rice")){
            return new Rice();
        }
        return null;
    }

    /**
     * 简单工厂2-多个方法 实现
     * @return
     */
/*    public Food getFruit(){
        return new Fruit();
    }

    public Food getRice(){
        return new Rice();
    }*/

    /**
     * 简单工厂3-多个静态方法实现
     */
    public static Food getFruit(){
        return new Fruit();
    }

    public static Food getRice(){
        return new Rice();
    }


}

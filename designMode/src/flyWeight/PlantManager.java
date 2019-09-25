package flyWeight;

import flyWeight.factory.PlantFactory;

import java.util.Random;

public class PlantManager {
    private int length = 10000000;
    private int[] xArray = new int[length];
    private int[] yArray = new int[length];
    private int[] ageArray = new int[length];
    private int[] typeArray = new int[length];

    private PlantFactory factory;

    public PlantManager(){
        factory = new PlantFactory();
        for(int i = 0;i<length;i++){
            xArray[i] = (int)Math.random()*length;
            yArray[i] = (int)Math.random()*length;
            ageArray[i] = (int)Math.random()*length%5;
            typeArray[i] = (int)Math.random()*length%2;
        }

    }

    public void displayPlants(){
        for(int i = 0;i<length;i++){
            factory.getPlant(typeArray[i]).display(xArray[i],yArray[i],ageArray[i]);
        }
    }
}

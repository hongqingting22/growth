package flyWeight.factory;

import flyWeight.Plant;
import flyWeight.impl.Grass;
import flyWeight.impl.Tree;

import java.util.HashMap;
import java.util.Map;

public class PlantFactory {
    private Map<Integer, Plant> map = new HashMap<>();

    public Plant getPlant(int type){
        if(!map.containsKey(type)){
            switch (type){
                case 0 : map.put(type, new Tree());break;
                case 1 : map.put(type, new Grass());break;
            }
        }
        return map.get(type);

    }
}

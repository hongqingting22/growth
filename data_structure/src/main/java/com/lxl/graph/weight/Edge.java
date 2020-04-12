package com.lxl.graph.weight;

import java.util.Map;

/**
 * 加权后的边
 */
public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private Map<WeightType, Double> weight;

    public Edge(int v, int w, Map<WeightType, Double> weightMap) {
        this.v = v;
        this.w = w;
        for (WeightType type : weightMap.keySet()) {
            addWeight(v,w,type, weightMap.get(type));
        }
    }



    public void addWeight(int v, int w, WeightType type, Double value){
        weight.put(type, value);
    }

    @Override
    public int compareTo(Edge o) {
        return 0;
    }

    public int compareTo(Edge other, WeightType type){
        double aDouble = this.weight(type);
        double weight = other.weight(type);
        double res = aDouble - weight;
        return  res > 0 ? 1 : (res == 0 ? 0 : -1);
    }


    public double weight(WeightType type){
        return weight.get(type);
    }

    public int other(int x){
        if(x == v){
            return w;
        }else{
            return v;
        }
    }

    public int getV() {
        return v;
    }
    public int getW() {
        return w;
    }
}

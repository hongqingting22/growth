package factory.simple.order;

import factory.simple.pizza.CheesePizze;
import factory.simple.pizza.ItalyPizze;
import factory.simple.pizza.Pizza;

import java.util.Scanner;

public class OrderPizza {
    public void order(String orderType){
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new CheesePizze();
        }else if(orderType.equals("Italy")){
            pizza = new ItalyPizze();
        }
        pizza.prepare();
        pizza.bake();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();

    }
}

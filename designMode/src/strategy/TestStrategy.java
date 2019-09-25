package strategy;

import strategy.strategyImpl.CommonMemberStrategy;
import strategy.strategyImpl.VipMemberStrategy;

import java.util.Scanner;

public class TestStrategy {
    public static void main(String[] args) {
        double totalPrice = 100;
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        MemberStrategy strategy = null;
        if(i>100){
            strategy = new VipMemberStrategy();
        }else{
            strategy = new CommonMemberStrategy();
        }
        Price price = new Price(strategy);
        double qu = price.quote(totalPrice);
        System.out.println(qu);
    }
}

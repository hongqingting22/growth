package strategy.strategyImpl;

import strategy.MemberStrategy;

public class CommonMemberStrategy implements MemberStrategy {
    @Override
    public double calPrice(double price) {
        return price;
    }
}

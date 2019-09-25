package strategy.strategyImpl;

import strategy.MemberStrategy;

public class VipMemberStrategy implements MemberStrategy {
    @Override
    public double calPrice(double price) {
        return price * 0.8;
    }
}

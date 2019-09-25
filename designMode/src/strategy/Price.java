package strategy;

public class Price {

    private MemberStrategy strategy;

    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    public double quote(double price){
        return this.strategy.calPrice(price);
    }
}

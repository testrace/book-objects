package call;

public class FixedRatePolicy implements RatePolicy {

    @Override
    public Money calculateFee(Phone phone) {
        return Money.wons(500);
    }
}

package movie;

public class NoneDiscountPolicy extends DiscountPolicy {

    public NoneDiscountPolicy(DiscountCondition... conditions) {
        super(conditions);
    }

    @Override
    Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}

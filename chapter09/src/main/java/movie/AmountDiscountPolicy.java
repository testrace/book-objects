package movie;

public class AmountDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return null;
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return null;
    }
}

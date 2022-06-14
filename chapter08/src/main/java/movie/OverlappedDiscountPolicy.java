package movie;

import java.util.ArrayList;
import java.util.List;

public class OverlappedDiscountPolicy implements DiscountPolicy {

    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return discountPolicies.stream()
            .reduce(Money.ZERO, (accumulated, policy) -> accumulated.plus(policy.getDiscountAmount(screening)), Money::plus);
    }
}

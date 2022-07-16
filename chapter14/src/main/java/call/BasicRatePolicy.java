package call;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasicRatePolicy implements RatePolicy {

    private List<FeeRule> feeRules = new ArrayList<>();

    public BasicRatePolicy(FeeRule... feeRules) {
        this.feeRules = Arrays.asList(feeRules);
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls().stream()
            .map(this::calculate)
            .reduce(Money.ZERO, Money::plus);
    }

    private Money calculate(Call call) {
        return feeRules.stream()
            .map(rule -> rule.calculateFee(call))
            .reduce(Money.ZERO, Money::plus);
    }

    protected abstract Money calculateCallFee(Call call);

}

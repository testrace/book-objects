package call;

public class FeeRule {

    private FeeCondition feeCondition;
    private FeePerDuration feePerDuration;

    public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
        this.feeCondition = feeCondition;
        this.feePerDuration = feePerDuration;
    }

    public Money calculateFee(Call call) {
        return feeCondition.findTimeIntervals(call).stream()
            .map(it -> feePerDuration.calculate(it))
            .reduce(Money.ZERO, Money::plus);

    }
}

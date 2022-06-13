package movie;

import java.util.Arrays;
import java.util.List;

public abstract class Movie {

    private String title;
    private Duration runningTIme;
    private Money fee;
    private List<DiscountCondition> discountConditions;


    Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTIme = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
            .anyMatch(condition -> condition.isDiscountable(screening));
    }

    protected Money getFee() {
        return fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }



    protected abstract Money calculateDiscountAmount();
}

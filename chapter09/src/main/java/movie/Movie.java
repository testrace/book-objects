package movie;

import java.time.Duration;

public class Movie {

    private final String title;
    private final Duration runningTIme;
    private final Money fee;
    private final DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTIme, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTIme = runningTIme;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAMount(screening));
    }
}

package movie;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Movie {

    private String title;
    private Duration runningTIme;
    private Money fee;
    private DiscountPolicy discountPolicy;

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

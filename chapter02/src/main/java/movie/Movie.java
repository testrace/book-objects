package movie;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy dIscountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy dIscountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.dIscountPolicy = dIscountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(dIscountPolicy.calculateDiscountAmount(screening));
    }
}

package movie;

public interface DiscountPolicy {

    Money getDiscountAmount(Screening screening);
}

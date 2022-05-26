package movie;

public class Money {

    public static final Money ZERO = new Money(0);

    int value;

    public Money(int value) {
        this.value = value;
    }

    public Money times(int audienceCount) {
        return null;
    }

    public Money times(double percent) {
        return new Money((int) (value * percent));
    }

    public Money minus(Money calculateDiscountAmount) {
        return new Money(value - calculateDiscountAmount.value);
    }
}

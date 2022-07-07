package call;

import java.math.BigDecimal;

public class Money {

    public static final Money ZERO = Money.wons(0L);

    private final BigDecimal amount;

    Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

//
//    public boolean isLessThan(Money other) {
//        return amount.compareTo(other.amount) < 0;
//    }
//
//    public boolean isGreatThanOrEqual(Money other) {
//        return amount.compareTo(other.amount) >= 0;
//    }


    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount +
            '}';
    }
}

package movie;

import java.time.Duration;

public class Factory {

    public Movie createAvatarMovie() {
        return new Movie("아바타", Duration.ofMinutes(120), Money.wons(10_000), new AmountDiscountPolicy());
    }
}

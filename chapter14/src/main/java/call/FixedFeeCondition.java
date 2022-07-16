package call;

import java.util.List;

public class FixedFeeCondition implements FeeCondition {

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return List.of(call.getInterval());
    }
}

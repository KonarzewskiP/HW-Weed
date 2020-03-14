package weedData.bestPricebyMonth;

import weedData.StateUSA;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface BestPriceByMonthBetweenAllStatesInterface {
    Map<Integer, Map<Integer, Optional<StateUSA>>> bestPriceByMonth();
}

package weedData.bestPriceByYear;

import weedData.StateUSA;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public interface BestPriceByYearBetweenAllStatestInterface {
    Map<Integer, Optional<StateUSA>> bestPriceByYear();
}

package weedData.bestPriceWeedForEachState;

import weedData.StateUSA;

import java.util.Map;
import java.util.Optional;

public interface BestPriceForEachStateInterface {
    Map<String, Optional<StateUSA>> bestPriceForEachState();
}

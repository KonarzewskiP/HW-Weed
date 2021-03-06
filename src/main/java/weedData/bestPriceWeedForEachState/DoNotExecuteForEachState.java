package weedData.bestPriceWeedForEachState;

import weedData.StateUSA;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoNotExecuteForEachState implements BestPriceForEachStateInterface {
    private final Logger logger = Logger.getLogger(DoNotExecuteForEachState.class.getName());

    @Override
    public Map<String, Optional<StateUSA>> bestPriceForEachState() {
        logger.log(Level.INFO, "Method not implemented");
        return Map.of();
    }
}

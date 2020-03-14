package weedData.bestPricebyMonth;

import weedData.StateUSA;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoNotExecuteByMonth implements BestPriceByMonthBetweenAllStatesInterface {
    private final Logger logger = Logger.getLogger(DoNotExecuteByMonth.class.getName());

    @Override
    public Map<Integer, Map<Integer, Optional<StateUSA>>> bestPriceByMonth() {
        logger.log(Level.INFO, "Method not implemented.");
        return Map.of();
    }
}

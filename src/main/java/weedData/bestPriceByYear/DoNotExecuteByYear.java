package weedData.bestPriceByYear;

import weedData.StateUSA;


import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DoNotExecuteByYear implements BestPriceByYearBetweenAllStatestInterface {
    private final Logger logger = Logger.getLogger(DoNotExecuteByYear.class.getName());


    @Override
    public Map<Integer, Optional<StateUSA>> bestPriceByYear() {
        logger.log(Level.INFO, "Method not implemented");
        return Map.of();
    }

}

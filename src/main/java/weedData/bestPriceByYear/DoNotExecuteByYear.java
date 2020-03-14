package weedData.bestPriceByYear;

import lombok.extern.java.Log;
import weedData.StateUSA;

import java.time.LocalDate;
import java.util.List;
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

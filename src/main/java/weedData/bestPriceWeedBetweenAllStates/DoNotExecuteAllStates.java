package weedData.bestPriceWeedBetweenAllStates;

import weedData.StateUSA;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoNotExecuteAllStates implements BestPriceInterface {
    private final Logger logger = Logger.getLogger(DoNotExecuteAllStates.class.getName());

    @Override
    public List<StateUSA> showBestPriceWeed(int number) {
        logger.log(Level.INFO, "Method not implemented");
        return Collections.emptyList();
    }
}

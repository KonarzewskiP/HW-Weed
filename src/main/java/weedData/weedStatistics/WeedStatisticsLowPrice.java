package weedData.weedStatistics;

import weedData.StateUSA;
import weedData.bestPriceByYear.BestLowPriceByYear;
import weedData.bestPriceWeedBetweenAllStates.BestLowPrice;
import weedData.bestPriceWeedForEachState.BestLowPriceEachState;
import weedData.bestPricebyMonth.BestLowPriceByMonth;
import weedData.priceListAndBestAveragePriceGenerator.AverageLowPriceList;

import java.util.List;

public class WeedStatisticsLowPrice extends WeedStatistics {
    public WeedStatisticsLowPrice(List<StateUSA> states) {
        priceListAndBestAvgPriceInterface = new AverageLowPriceList(states);
        bestPriceInterface = new BestLowPrice(states);
        bestPriceForEachStateInterface = new BestLowPriceEachState(states);
        bestPriceByYearBetweenAllStatestInterface = new BestLowPriceByYear(states);
        bestPriceByMonthBetweenAllStatesInterface = new BestLowPriceByMonth(states);
    }
}

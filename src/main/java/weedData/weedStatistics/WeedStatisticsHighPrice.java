package weedData.weedStatistics;

import weedData.StateUSA;
import weedData.bestPriceByYear.BestHighPriceByYear;
import weedData.bestPriceWeedBetweenAllStates.BestHighPrice;
import weedData.bestPriceWeedForEachState.BestHighPriceEachState;
import weedData.bestPricebyMonth.BestHighPriceByMonth;
import weedData.priceListAndBestAveragePriceGenerator.AverageHighPriceList;
import weedData.sortByDate.SortHighPriceByDate;

import java.util.List;

public class WeedStatisticsHighPrice extends WeedStatistics{
    public WeedStatisticsHighPrice(List<StateUSA> states) {
        priceListAndBestAvgPriceInterface = new AverageHighPriceList(states);
        bestPriceInterface = new BestHighPrice(states);
        bestPriceForEachStateInterface = new BestHighPriceEachState(states);
        bestPriceByYearBetweenAllStatestInterface = new BestHighPriceByYear(states);
        bestPriceByMonthBetweenAllStatesInterface = new BestHighPriceByMonth(states);
        statisticsSortedByDate= new SortHighPriceByDate(states);
    }
}

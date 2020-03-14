package weedData.weedStatistics;

import weedData.StateUSA;
import weedData.priceListGenerator.AverageHighPriceList;

import java.util.List;

public class WeedStatisticsHighPrice extends WeedStatistics{
    public WeedStatisticsHighPrice(List<StateUSA> states) {
        priceListGeneratorInterface = new AverageHighPriceList(states);
    }
}

package weedData.priceListAndBestAveragePriceGenerator;

import weedData.StateWithAvgPrices;

import java.util.List;
import java.util.Map;

public interface PriceListAndBestAvgPriceInterface {
     Map<String, StateWithAvgPrices> statesWithAveragePricesList();
     List<StateWithAvgPrices> sortedNumberStatesWithBestPrice(int number);
}

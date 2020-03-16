package weedData.priceListAndBestAveragePriceGenerator;

import weedData.StateWithAvgPrices;

import java.util.List;
import java.util.Map;

// Nie piszemy 'Interface' na koncu nazwy interfejsu
public interface PriceListAndBestAvgPriceInterface {
     Map<String, StateWithAvgPrices> statesWithAveragePricesList();
     List<StateWithAvgPrices> sortedNumberStatesWithBestPrice(int number);
}

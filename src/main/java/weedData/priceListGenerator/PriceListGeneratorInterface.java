package weedData.priceListGenerator;

import weedData.StateWithAvgPrices;

import java.util.List;
import java.util.Map;

public interface PriceListGeneratorInterface {
    public Map<String, StateWithAvgPrices> statesWithPricesList();
    public List<StateWithAvgPrices> sortedNumberStatesWithBestPrice(int number);
}

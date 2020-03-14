package weedData.priceListGenerator;

import weedData.StateUSA;
import weedData.StateWithAvgPrices;
import weedData.States;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageHighPriceList implements PriceListGeneratorInterface {
    private final List<StateUSA> statesUSA;

    public AverageHighPriceList(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public Map<String, StateWithAvgPrices> statesWithPricesList() {
        Map<String, StateWithAvgPrices> state = new HashMap<>();
        for (StateUSA s : statesUSA) {
            StateWithAvgPrices stateWithAvgPrices = new StateWithAvgPrices();
            BigDecimal averageHighPrice = avgHighPrice(s.getStateAbbreviation());
            stateWithAvgPrices.setAvgHigh(averageHighPrice);
            stateWithAvgPrices.setName(s.getStateName());
            state.put(s.getStateName(), stateWithAvgPrices);
        }
        return state;
    }

    private BigDecimal avgHighPrice(States state) {
        double number = statesUSA.stream()
                .filter(states1 -> states1.getStateAbbreviation() == state)
                .collect(Collectors.averagingDouble(value -> value.getHighQuality().doubleValue()));
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public List<StateWithAvgPrices> sortedNumberStatesWithBestPrice(int number){
        return statesWithPricesList()
                .values()
                .stream()
                .sorted(new Comparator<StateWithAvgPrices>() {
                    @Override
                    public int compare(StateWithAvgPrices o1, StateWithAvgPrices o2) {
                        return o1.getAvgHigh().compareTo(o2.getAvgHigh());
                    }
                })
                .limit(number)
                .collect(Collectors.toList());
    }
}

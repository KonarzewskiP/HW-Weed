package weedData.bestPriceByYear;

import weedData.StateUSA;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;

public class BestMediumPriceByYear implements BestPriceByYearBetweenAllStatestInterface {
    private final List<StateUSA> statesUSA;

    public BestMediumPriceByYear(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public Map<Integer, Optional<StateUSA>> bestPriceByYear() {
        return statesUSA
                .stream()
                .collect(groupingBy(stateUSA -> stateUSA.getDate().getYear(),minBy(Comparator.comparing(StateUSA::getMediumQuality))));
    }
    }


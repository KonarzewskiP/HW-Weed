package weedData.priceListAndBestAveragePriceGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weedData.StateUSA;
import weedData.StateWithAvgPrices;
import weedData.States;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AverageAllPriceListTest {
    private List<StateUSA> statesUSA = new ArrayList<>();
    private StateUSA record1 = new StateUSA("Alabama", States.AL, new BigDecimal("1"), new BigDecimal("20"), new BigDecimal("10"), LocalDate.of(2014, 8, 1));
    private StateUSA record2 = new StateUSA("New York", States.NY, new BigDecimal("11"), new BigDecimal("21"), new BigDecimal("32"), LocalDate.of(2014, 8, 28));
    private StateUSA record3 = new StateUSA("Florida", States.FL, new BigDecimal("15"), new BigDecimal("30"), new BigDecimal("24"), LocalDate.of(2014, 8, 4));
    private StateUSA record4 = new StateUSA("Alabama", States.AL, new BigDecimal("60"), new BigDecimal("13"), new BigDecimal("40"), LocalDate.of(2014, 7, 5));
    private StateUSA record5 = new StateUSA("New York", States.NY, new BigDecimal("40"), new BigDecimal("2"), new BigDecimal("60"), LocalDate.of(2014, 7, 6));
    private StateUSA record6 = new StateUSA("Florida", States.FL, new BigDecimal("41"), new BigDecimal("20"), new BigDecimal("60"), LocalDate.of(2014, 7, 6));
    private StateUSA record7 = new StateUSA("New York", States.NY, new BigDecimal("50"), new BigDecimal("60"), new BigDecimal("31"), LocalDate.of(2017, 4, 4));
    private StateUSA record8 = new StateUSA("Alabama", States.AL, new BigDecimal("70"), new BigDecimal("60"), new BigDecimal("30"), LocalDate.of(2017, 4, 4));
    private StateUSA record9 = new StateUSA("Florida", States.FL, new BigDecimal("50"), new BigDecimal("15"), new BigDecimal("3"), LocalDate.of(2017, 4, 4));


    @Test
    void statesWithAveragePricesList() {
        //given
        statesUSA.add(record1);
        statesUSA.add(record2);
        statesUSA.add(record3);
        statesUSA.add(record4);
        statesUSA.add(record5);
        statesUSA.add(record6);
        statesUSA.add(record7);
        statesUSA.add(record8);
        statesUSA.add(record9);

        //when
        AverageAllPriceList avgTest = new AverageAllPriceList(statesUSA);
        Map<String, StateWithAvgPrices> actual = avgTest.statesWithAveragePricesList();

        //then
        assertThat(actual.size()).isEqualTo(3);

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(stateUSA1 -> stateUSA1.getName().equals("Alabama"))
                .map(StateWithAvgPrices::getAverageTotal)
                .findFirst(), Optional.of(new BigDecimal("33.78")), "Test no 1. Average price for all quality for Alabama");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(stateUSA1 -> stateUSA1.getName().equals("New York"))
                .map(StateWithAvgPrices::getAverageTotal)
                .findFirst(), Optional.of(new BigDecimal("34.11")), "Test no 2. Average price for all quality for New York");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(stateUSA1 -> stateUSA1.getName().equals("Florida"))
                .map(StateWithAvgPrices::getAverageTotal)
                .findFirst(), Optional.of(new BigDecimal("28.66")), "Test no 3. Average price for all quality for Florida");
    }

    @Test
    void sortedNumberStatesWithBestPrice() {
        //given
        statesUSA.add(record1);
        statesUSA.add(record2);
        statesUSA.add(record3);
        statesUSA.add(record4);
        statesUSA.add(record5);
        statesUSA.add(record6);
        statesUSA.add(record7);
        statesUSA.add(record8);
        statesUSA.add(record9);
        //when
        AverageAllPriceList avgTest = new AverageAllPriceList(statesUSA);
        List<StateWithAvgPrices> actual = avgTest.sortedNumberStatesWithBestPrice(3);
        //then
        assertThat(actual.size()).isEqualTo(3);

        Assertions.assertEquals(actual
                .stream()
                .map(StateWithAvgPrices::getName)
                .findFirst(), Optional.of("Florida"), "Test no 1. State with the cheapest weed");

        Assertions.assertEquals(actual
                .stream()
                .map(StateWithAvgPrices::getName)
                .reduce((s1, s2) -> s2), Optional.of("New York"), "Test no 2. State with the most expensive weed");

    }
}
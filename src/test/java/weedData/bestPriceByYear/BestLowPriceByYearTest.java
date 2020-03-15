package weedData.bestPriceByYear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weedData.StateUSA;
import weedData.States;
import weedData.bestPricebyMonth.BestHighPriceByMonth;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BestLowPriceByYearTest {

    @Test
    void bestPriceByYear() {
        //given
        List<StateUSA> stateUSA = new ArrayList<>();
        StateUSA record1 = new StateUSA("Alabama", States.AL, new BigDecimal("1"), new BigDecimal("20"), new BigDecimal("10"), LocalDate.of(2014, 8, 1));
        StateUSA record2 = new StateUSA("New York", States.NY, new BigDecimal("11"), new BigDecimal("21"), new BigDecimal("32"), LocalDate.of(2014, 8, 28));
        StateUSA record3 = new StateUSA("Florida", States.FL, new BigDecimal("15"), new BigDecimal("30"), new BigDecimal("24"), LocalDate.of(2014, 8, 4));
        StateUSA record4 = new StateUSA("Alabama", States.AL, new BigDecimal("60"), new BigDecimal("13"), new BigDecimal("40"), LocalDate.of(2014, 7, 5));
        StateUSA record5 = new StateUSA("New York", States.NY, new BigDecimal("40"), new BigDecimal("2"), new BigDecimal("60"), LocalDate.of(2014, 7, 6));
        StateUSA record6 = new StateUSA("Florida", States.FL, new BigDecimal("41"), new BigDecimal("20"), new BigDecimal("60"), LocalDate.of(2014, 7, 6));
        StateUSA record7 = new StateUSA("New York", States.NY, new BigDecimal("50"), new BigDecimal("60"), new BigDecimal("31"), LocalDate.of(2017, 4, 4));
        StateUSA record8 = new StateUSA("Alabama", States.AL, new BigDecimal("70"), new BigDecimal("60"), new BigDecimal("30"), LocalDate.of(2017, 4, 4));
        StateUSA record9 = new StateUSA("Florida", States.FL, new BigDecimal("50"), new BigDecimal("15"), new BigDecimal("3"), LocalDate.of(2017, 4, 4));

        stateUSA.add(record1);
        stateUSA.add(record2);
        stateUSA.add(record3);
        stateUSA.add(record4);
        stateUSA.add(record5);
        stateUSA.add(record6);
        stateUSA.add(record7);
        stateUSA.add(record8);
        stateUSA.add(record9);
        //when
        BestLowPriceByYear bestTest = new BestLowPriceByYear(stateUSA);
        Map<Integer, Optional<StateUSA>> actual = bestTest.bestPriceByYear();
        //then
        assertThat(actual.size()).isEqualTo(2);


        Assertions.assertEquals(actual
                .values()
                .stream()
                .map(state1-> state1.get().getLowQuality() )
                .sorted()
                .findFirst(), Optional.of(new BigDecimal("3")), "Test no 1.");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(stateUSA1 -> stateUSA1.get().getDate().getYear() == 2014)
                .map(state -> state.get().getLowQuality())
                .findFirst(), Optional.of(new BigDecimal("10")), "Test no 2.");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(stateUSA1 -> stateUSA1.get().getDate().getYear() == 2017)
                .map(state -> state.get().getLowQuality())
                .findFirst(), Optional.of(new BigDecimal("3")), "Test no 3.");

    }
}
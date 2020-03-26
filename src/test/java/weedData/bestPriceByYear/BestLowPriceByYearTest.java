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
        List<StateUSA> stateUSA = List.of(
        new StateUSA("New York", States.NY, new BigDecimal("50"), new BigDecimal("60"), new BigDecimal("31"), LocalDate.of(2017, 4, 4)),
        new StateUSA("Alabama", States.AL, new BigDecimal("70"), new BigDecimal("60"), new BigDecimal("30"), LocalDate.of(2017, 4, 4)),
        new StateUSA("Florida", States.FL, new BigDecimal("50"), new BigDecimal("15"), new BigDecimal("3"), LocalDate.of(2017, 4, 4)),
        new StateUSA("Alabama", States.AL, new BigDecimal("1"), new BigDecimal("20"), new BigDecimal("10"), LocalDate.of(2014, 8, 1)),
        new StateUSA("New York", States.NY, new BigDecimal("11"), new BigDecimal("21"), new BigDecimal("32"), LocalDate.of(2014, 8, 28)),
        new StateUSA("Florida", States.FL, new BigDecimal("15"), new BigDecimal("30"), new BigDecimal("24"), LocalDate.of(2014, 8, 4)),
        new StateUSA("Alabama", States.AL, new BigDecimal("60"), new BigDecimal("13"), new BigDecimal("40"), LocalDate.of(2014, 7, 5)),
        new StateUSA("New York", States.NY, new BigDecimal("40"), new BigDecimal("2"), new BigDecimal("60"), LocalDate.of(2014, 7, 6)),
        new StateUSA("Florida", States.FL, new BigDecimal("41"), new BigDecimal("20"), new BigDecimal("60"), LocalDate.of(2014, 7, 6))
        );
        //when
        BestLowPriceByYear bestTest = new BestLowPriceByYear(stateUSA);
        Map<Integer, Optional<StateUSA>> actual = bestTest.bestPriceByYear();
        //then
        assertThat(actual.size()).isEqualTo(2);


        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(StateUSA::getLowQuality)
                .sorted()
                .findFirst(), Optional.of(new BigDecimal("3")), "Test no 1.");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stateUSA1 -> stateUSA1.getDate().getYear() == 2014)
                .map(StateUSA::getLowQuality)
                .findFirst(), Optional.of(new BigDecimal("10")), "Test no 2.");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stateUSA1 -> stateUSA1.getDate().getYear() == 2017)
                .map(StateUSA::getLowQuality)
                .findFirst(), Optional.of(new BigDecimal("3")), "Test no 3.");

    }
}
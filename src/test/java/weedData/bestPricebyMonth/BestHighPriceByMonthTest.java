package weedData.bestPricebyMonth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weedData.StateUSA;
import weedData.States;
import weedData.bestPriceWeedForEachState.BestMediumPriceEachState;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BestHighPriceByMonthTest {

    @Test
    void bestHighPriceByMonth() {
        //given
        List<StateUSA> stateUSA = List.of(
        new StateUSA("Alabama", States.AL, new BigDecimal("1"), new BigDecimal("20"), new BigDecimal("10"), LocalDate.of(2014, 8, 1)),
        new StateUSA("New York", States.NY, new BigDecimal("11"), new BigDecimal("21"), new BigDecimal("32"), LocalDate.of(2014, 8, 28)),
        new StateUSA("Florida", States.FL, new BigDecimal("15"), new BigDecimal("30"), new BigDecimal("24"), LocalDate.of(2014, 8, 4)),
        new StateUSA("Alabama", States.AL, new BigDecimal("60"), new BigDecimal("13"), new BigDecimal("40"), LocalDate.of(2014, 7, 5)),
        new StateUSA("New York", States.NY, new BigDecimal("40"), new BigDecimal("2"), new BigDecimal("60"), LocalDate.of(2014, 7, 6)),
        new StateUSA("Florida", States.FL, new BigDecimal("41"), new BigDecimal("20"), new BigDecimal("60"), LocalDate.of(2014, 7, 6)),
        new StateUSA("New York", States.NY, new BigDecimal("50"), new BigDecimal("60"), new BigDecimal("31"), LocalDate.of(2017, 4, 4)),
        new StateUSA("Alabama", States.AL, new BigDecimal("70"), new BigDecimal("60"), new BigDecimal("30"), LocalDate.of(2017, 4, 4)),
        new StateUSA("Florida", States.FL, new BigDecimal("50"), new BigDecimal("15"), new BigDecimal("3"), LocalDate.of(2017, 4, 4))
        );
        //when
        BestHighPriceByMonth bestTest = new BestHighPriceByMonth(stateUSA);
        Map<Integer, Map<Integer, Optional<StateUSA>>> actual = bestTest.bestPriceByMonth();
        //then
        assertThat(actual.size()).isEqualTo(2);


        Assertions.assertEquals(actual
                .values()
                .stream()
                .flatMap(st->st.values().stream())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(StateUSA::getHighQuality)
                .sorted()
                .findFirst(), Optional.of(new BigDecimal("1")), "Test no 1. The lowest value of all time");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .flatMap(st->st.values().stream())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stateUSA1 -> stateUSA1.getDate().getMonth().getValue() == 8)
                .map(StateUSA::getHighQuality)
                .findFirst(), Optional.of(new BigDecimal("1")), "Test no 2. For month nr 8.");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .flatMap(st->st.values().stream())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stateUSA1 -> stateUSA1.getDate().getMonth().getValue() == 7)
                .map(state -> state.getHighQuality())
                .findFirst(), Optional.of(new BigDecimal("40")), "Test no 3. For month nr 7.");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .flatMap(st->st.values().stream())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stateUSA1 -> stateUSA1.getDate().getMonth().getValue() == 4)
                .map(state -> state.getHighQuality())
                .findFirst(), Optional.of(new BigDecimal("50")), "Test no 4. For month nr 4.");
    }
}
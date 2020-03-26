package weedData.bestPriceWeedForEachState;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import weedData.StateUSA;
import weedData.States;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.shouldHaveThrown;

class BestMediumPriceEachStateTest {

    @Test
    void bestPriceForEachState() {
        //given
        List<StateUSA> stateUSA = List.of(
        new StateUSA("Alabama", States.AL, new BigDecimal("1"), new BigDecimal("20"), new BigDecimal("10"), LocalDate.of(2014, 8, 1)),
        new StateUSA("New York", States.NY, new BigDecimal("11"), new BigDecimal("21"), new BigDecimal("32"), LocalDate.of(2014, 8, 28)),
        new StateUSA("Florida", States.FL, new BigDecimal("15"), new BigDecimal("30"), new BigDecimal("24"), LocalDate.of(2014, 8, 4)),
        new StateUSA("Alabama", States.AL, new BigDecimal("60"), new BigDecimal("13"), new BigDecimal("40"), LocalDate.of(2014, 7, 5)),
        new StateUSA("New York", States.NY, new BigDecimal("40"), new BigDecimal("2"), new BigDecimal("60"), LocalDate.of(2014, 7, 6)),
        new StateUSA("Florida", States.FL, new BigDecimal("40"), new BigDecimal("20"), new BigDecimal("60"), LocalDate.of(2014, 7, 6)),
        new StateUSA("New York", States.NY, new BigDecimal("50"), new BigDecimal("60"), new BigDecimal("31"), LocalDate.of(2017, 4, 4)),
        new StateUSA("Alabama", States.AL, new BigDecimal("50"), new BigDecimal("60"), new BigDecimal("30"), LocalDate.of(2017, 4, 4)),
        new StateUSA("Florida", States.FL, new BigDecimal("50"), new BigDecimal("15"), new BigDecimal("3"), LocalDate.of(2017, 4, 4))
        );
        //when
        BestMediumPriceEachState bestTest = new BestMediumPriceEachState(stateUSA);
        Map<String, Optional<StateUSA>> actual = bestTest.bestPriceForEachState();
        //then
        assertThat(actual.size()).isEqualTo(3);


        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(StateUSA::getMediumQuality)
                .sorted()
                .findFirst(), Optional.of(new BigDecimal("2")), "Test no 1.");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stateUSA1 -> stateUSA1.getStateName().equals("Alabama"))
                .map(StateUSA::getMediumQuality)
                .findFirst(),Optional.of(new BigDecimal("13")),"Test no 2. for Alabama");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stateUSA1 -> stateUSA1.getStateName().equals("New York"))
                .map(StateUSA::getMediumQuality)
                .findFirst(),Optional.of(new BigDecimal("2")),"Test no 2. for New York");

        Assertions.assertEquals(actual
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(stateUSA1 -> stateUSA1.getStateName().equals("Florida"))
                .map(StateUSA::getMediumQuality)
                .findFirst(),Optional.of(new BigDecimal("15")),"Test no 2. for Florida");




    }
}
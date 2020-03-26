package weedData.importing;

import weedData.StateUSA;
import weedData.States;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateMapper {
    private final Logger logger = Logger.getLogger(StateMapper.class.getName());

    Optional<StateUSA> fromLineHighMedLowQuality(String[] fields) {
        try {
            return Optional.of(
                    StateUSA.builder()
                            .withStateName(fields[0])
                            .withStateAbbreviation(States.of(fields[0]))
                            .withHighQuality(new BigDecimal(fields[1]))
                            .withMediumQuality(new BigDecimal(fields[3]))
                            .withLowQuality(new BigDecimal(fields[5]))
                            .withDate(fields[7])
                            .build()
            );
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }

    Optional<StateUSA> fromLineHighQuality(String[] fields) {
        try {
            return Optional.of(
                    StateUSA.builder()
                            .withStateName(fields[0])
                            .withStateAbbreviation(States.of(fields[0]))
                            .withHighQuality(new BigDecimal(fields[1]))
//                            .withMediumQuality(new BigDecimal(fields[3]))
//                            .withLowQuality(new BigDecimal(fields[5]))
                            .withDate(fields[7])
                            .build()
            );
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }
    Optional<StateUSA> fromLineMediumQuality(String[] fields) {
        try {
            return Optional.of(
                    StateUSA.builder()
                            .withStateName(fields[0])
                            .withStateAbbreviation(States.of(fields[0]))
//                            .withHighQuality(new BigDecimal(fields[1]))
                            .withMediumQuality(new BigDecimal(fields[3]))
//                            .withLowQuality(new BigDecimal(fields[5]))
                            .withDate(fields[7])
                            .build()
            );
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }
    Optional<StateUSA> fromLineLowQuality(String[] fields) {
        try {
            return Optional.of(
                    StateUSA.builder()
                            .withStateName(fields[0])
                            .withStateAbbreviation(States.of(fields[0]))
//                            .withHighQuality(new BigDecimal(fields[1]))
//                            .withMediumQuality(new BigDecimal(fields[3]))
                            .withLowQuality(new BigDecimal(fields[5]))
                            .withDate(fields[7])
                            .build()
            );
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }
}


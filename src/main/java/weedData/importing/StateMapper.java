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
            Optional<StateUSA> build = Optional.of(
                    StateUSA.builder()
                            .setStateName(fields[0])
                            .setStateAbbreviation(States.stateAbbrevation(fields[0]))
                            .setHighQuality(new BigDecimal(fields[1]))
                            .setMediumQuality(new BigDecimal(fields[3]))
                            .setLowQuality(new BigDecimal(fields[5]))
                            .setDate(fields[7])
                            .build()
            );
            return build;
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }

    Optional<StateUSA> fromLineHighQuality(String[] fields) {
        try {
            Optional<StateUSA> build = Optional.of(
                    StateUSA.builder()
                            .setStateName(fields[0])
                            .setStateAbbreviation(States.stateAbbrevation(fields[0]))
                            .setHighQuality(new BigDecimal(fields[1]))
//                            .setMediumQuality(new BigDecimal(fields[3]))
//                            .setLowQuality(new BigDecimal(fields[5]))
                            .setDate(fields[7])
                            .build()
            );
            return build;
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }
    Optional<StateUSA> fromLineMediumQuality(String[] fields) {
        try {
            Optional<StateUSA> build = Optional.of(
                    StateUSA.builder()
                            .setStateName(fields[0])
                            .setStateAbbreviation(States.stateAbbrevation(fields[0]))
//                            .setHighQuality(new BigDecimal(fields[1]))
                            .setMediumQuality(new BigDecimal(fields[3]))
//                            .setLowQuality(new BigDecimal(fields[5]))
                            .setDate(fields[7])
                            .build()
            );
            return build;
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }
    Optional<StateUSA> fromLineLowQuality(String[] fields) {
        try {
            Optional<StateUSA> build = Optional.of(
                    StateUSA.builder()
                            .setStateName(fields[0])
                            .setStateAbbreviation(States.stateAbbrevation(fields[0]))
//                            .setHighQuality(new BigDecimal(fields[1]))
//                            .setMediumQuality(new BigDecimal(fields[3]))
                            .setLowQuality(new BigDecimal(fields[5]))
                            .setDate(fields[7])
                            .build()
            );
            return build;
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }
}


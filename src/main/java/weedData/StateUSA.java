package weedData;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StateUSA implements Comparable<StateUSA> {
    private String stateName;
    private States stateAbbreviation;
    private BigDecimal highQuality;
    private BigDecimal mediumQuality;
    private BigDecimal lowQuality;
    private LocalDate date;

    private StateUSA(StateUSABuilder stateUSABuilder) {
        // to powinno sie dziać w metodzie build() buildera
        // StateUSA nie powinno o builderze nic wiedzieć
        this.stateName = stateUSABuilder.stateName;
        this.stateAbbreviation = stateUSABuilder.stateAbbreviation;
        this.highQuality = stateUSABuilder.highQuality;
        this.mediumQuality = stateUSABuilder.mediumQuality;
        this.lowQuality = stateUSABuilder.lowQuality;
        this.date = stateUSABuilder.date;
    }

    public static StateUSABuilder builder() {
        return new StateUSABuilder();
    }

    @Override
    public int compareTo(StateUSA o) {
        return this.stateName.compareTo(o.getStateName());
    }

    public static class StateUSABuilder {
        private String stateName;
        private States stateAbbreviation;
        private BigDecimal highQuality;
        private BigDecimal mediumQuality;
        private BigDecimal lowQuality;
        private LocalDate date;

        // Zazwyczaj metody buildera nazywaja sie with... albo po prostu tak jak zmienna
        // W tym przypadku withStateName lub stateName
        public StateUSABuilder setStateName(String stateName) {
            this.stateName = stateName;
            return this;
        }

        public StateUSABuilder setStateAbbreviation(States state) {
            this.stateAbbreviation = state;
            return this;
        }

        public StateUSABuilder setHighQuality(BigDecimal highQuality) {
            this.highQuality = highQuality;
            return this;
        }

        public StateUSABuilder setMediumQuality(BigDecimal mediumQuality) {
            this.mediumQuality = mediumQuality;
            return this;
        }

        public StateUSABuilder setLowQuality(BigDecimal lowQuality) {
            this.lowQuality = lowQuality;
            return this;
        }

        public StateUSABuilder setDate(String date) {
            String[] dataSplit = date.split("-");
            this.date = LocalDate.of
                    (Integer.parseInt(dataSplit[0]),Integer.parseInt(dataSplit[1]),Integer.parseInt(dataSplit[2]));
            return this;
        }

        public StateUSA build() {
            return new StateUSA(this);
        }
    }
}

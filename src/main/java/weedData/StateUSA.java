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

        public StateUSA build() {
            StateUSA newState = new StateUSA();
            newState.stateName = this.stateName;
            newState.stateAbbreviation = this.stateAbbreviation;
            newState.highQuality = this.highQuality;
            newState.mediumQuality = this.mediumQuality;
            newState.lowQuality = this.lowQuality;
            newState.date = this.date;

            return newState;
        }

        public StateUSABuilder withStateName(String stateName) {
            this.stateName = stateName;
            return this;
        }

        public StateUSABuilder withStateAbbreviation(States state) {
            this.stateAbbreviation = state;
            return this;
        }

        public StateUSABuilder withHighQuality(BigDecimal highQuality) {
            this.highQuality = highQuality;
            return this;
        }

        public StateUSABuilder withMediumQuality(BigDecimal mediumQuality) {
            this.mediumQuality = mediumQuality;
            return this;
        }

        public StateUSABuilder withLowQuality(BigDecimal lowQuality) {
            this.lowQuality = lowQuality;
            return this;
        }

        public StateUSABuilder withDate(String date) {
            String[] dataSplit = date.split("-");
            this.date = LocalDate.of
                    (Integer.parseInt(dataSplit[0]), Integer.parseInt(dataSplit[1]), Integer.parseInt(dataSplit[2]));
            return this;
        }

    }
}

package weedData;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StateWithAvgPrices {
    private String name;
    private BigDecimal avgHigh;
    private BigDecimal avgMedium;
    private BigDecimal avgLow;
    private BigDecimal averageTotal;

    public void setBestAvg(){
        this.averageTotal = average();
    }
    private BigDecimal average(){
        return (avgHigh.add(avgMedium).add(avgLow)).divide(new BigDecimal(3),RoundingMode.DOWN);
    }
}

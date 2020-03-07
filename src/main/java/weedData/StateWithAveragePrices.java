package weedData;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class StateWithAveragePrices {
    private final String name;
    private BigDecimal averageHighPrice;
    private BigDecimal averageMediumPrice;
    private BigDecimal averageLowPrice;

    public StateWithAveragePrices(String name) {
        this.name = name;
    }

}

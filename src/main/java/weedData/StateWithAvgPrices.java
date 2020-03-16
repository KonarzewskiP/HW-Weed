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

    // Zamiast tej metody lepiej zawsze korzystać z metody average()
    // Przyklad - po zmianie ktorejkolwiek sredniej, wartosc zmiennej
    // averageTotal sie dezaktualizuje.
    // Dlatego zamiast przypisywac, to lepiej wyliczac na biezaco
    public void setBestAvg(){
        this.averageTotal = average();
    }
    private BigDecimal average(){
        return avgHigh.add(avgMedium).add(avgLow).divide(new BigDecimal(3),RoundingMode.DOWN);
    }
}

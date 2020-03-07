package weedData;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
public class WeedStatistics {
    private List<StateUSA> states;

    public WeedStatistics(List<StateUSA> states) {
        this.states = states;
    }

    public Map<String, StateWithAveragePrices> averageWeedPriceByState() {
        Map<String, StateWithAveragePrices> mapStates = new HashMap<>();
        for (States state : States.values()) {
            StateWithAveragePrices stateWithAveragePrices = new StateWithAveragePrices(States.stateAsString(state));
            BigDecimal highPrice = averageHighPrice(state);
            stateWithAveragePrices.setAverageHighPrice(new BigDecimal(String.valueOf(highPrice)));
            BigDecimal medPrice = averageMidPrice(state);
            stateWithAveragePrices.setAverageMediumPrice(new BigDecimal(String.valueOf(medPrice)));
            BigDecimal lowPrice = averageLowPrice(state);
            stateWithAveragePrices.setAverageLowPrice(new BigDecimal(String.valueOf(lowPrice)));
            mapStates.put(States.stateAsString(state), stateWithAveragePrices);
        }
        return mapStates;
    }

/*

    public Map<String,StateWithAveragePrices> stateWithBestHighPrice(){
      Map<String , StateWithAveragePrices> bestState = new HashMap<>();
      for (States st : States.values()){
          Optional<StateWithAveragePrices> best = highPrice(st);
      }
    }

    private Optional<StateWithAveragePrices> highPrice(States state){
        return states.stream()
                .filter(stateUSA -> )
    }
*/

//    public Map<String,StateWithAveragePrices> stateWithBestMediumPrice(){
//
//    }
//    public Map<String,StateWithAveragePrices> stateWithBestLowPrice(){
//
//    }

    private BigDecimal averageHighPrice(States state) {
        BigDecimal total = BigDecimal.ZERO;
        int count = 0;
        for (StateUSA stateName : states) {
            if (stateName.getStateAbbreviation().equals(state) && !stateName.getStateAbbreviation().equals(States.UNKNOW)) {
                if (stateName.getHighQuality() !=null) {
                    total = total.add(stateName.getHighQuality());
                    count++;
                } else{
                    continue;
                }
            }
        }
        System.out.println(count);
        return total.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal averageMidPrice(States state) {
        BigDecimal total = new BigDecimal("0");
        int count = 0;
        for (StateUSA stateName : states) {
            if (stateName.getStateAbbreviation().equals(state)) {
                assert false;
                total.add(stateName.getMediumQuality());
                count++;
            }
        }

        return total.divide(new BigDecimal(count));
    }


    private BigDecimal averageLowPrice(States state) {
        BigDecimal total = new BigDecimal("0");
        int count = 0;
        for (StateUSA stateName : states) {
            if (stateName.getStateAbbreviation().equals(state)) {
                assert false;
                total.add(stateName.getLowQuality());
                count++;
            }
        }
        return total.divide(new BigDecimal(count));
    }
}

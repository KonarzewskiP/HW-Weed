package weedData;

import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
public class WeedStatistics {
    private List<StateUSA> states;

    public WeedStatistics(List<StateUSA> states) {
        this.states = states;
    }




}

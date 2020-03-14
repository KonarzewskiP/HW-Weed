package weedData.importing;

import weedData.StateUSA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataImporter {
    private final StateMapper STATE_MAPPER = new StateMapper();
    private final String pathToFile;

    public DataImporter(String path) {
        this.pathToFile = path;
    }

    public List<StateUSA> readStatesHighMediumLowQuality(){
        List<StateUSA> collect = fileAsLine()
                .map(line -> line.split(","))
                .map(state -> STATE_MAPPER.fromLineHighMedLowQuality(state))
                .filter(stateUSA -> stateUSA.isPresent())
                .map(stateUSA -> stateUSA.get())
                .collect(Collectors.toList());
        return collect;
    }
    public List<StateUSA> readStatesHighQuality(){
        List<StateUSA> collect = fileAsLine()
                .map(line -> line.split(","))
                .map(state -> STATE_MAPPER.fromLineHighQuality(state))
                .filter(stateUSA -> stateUSA.isPresent())
                .map(stateUSA -> stateUSA.get())
                .collect(Collectors.toList());
        return collect;
    }

    public List<StateUSA> readStatesMediumQuality(){
        List<StateUSA> collect = fileAsLine()
                .map(line -> line.split(","))
                .map(state -> STATE_MAPPER.fromLineMediumQuality(state))
                .filter(stateUSA -> stateUSA.isPresent())
                .map(stateUSA -> stateUSA.get())
                .collect(Collectors.toList());
        return collect;
    }

    public List<StateUSA> readStatesLowQuality(){
        List<StateUSA> collect = fileAsLine()
                .map(line -> line.split(","))
                .map(STATE_MAPPER::fromLineLowQuality)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        return collect;
    }

    private Stream<String > fileAsLine(){
        try{
            return Files.lines(Paths.get(pathToFile));
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}

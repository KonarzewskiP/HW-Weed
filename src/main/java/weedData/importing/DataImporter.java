package weedData.importing;

import weedData.StateUSA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class  DataImporter {
    private final StateMapper STATE_MAPPER = new StateMapper();
    private final String pathToFile;

    public DataImporter(String path) {
        this.pathToFile = path;
    }

    public List<StateUSA> readStatesHighMediumLowQuality(){
        return fileAsLine()
                .map(line -> line.split(","))
                .map(STATE_MAPPER::fromLineHighMedLowQuality)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
    public List<StateUSA> readStatesHighQuality(){
        return fileAsLine()
                .map(line -> line.split(","))
                .map(STATE_MAPPER::fromLineHighQuality)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<StateUSA> readStatesMediumQuality(){
        return fileAsLine()
                .map(line -> line.split(","))
                .map(STATE_MAPPER::fromLineMediumQuality)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<StateUSA> readStatesLowQuality(){
        return fileAsLine()
                .map(line -> line.split(","))
                .map(STATE_MAPPER::fromLineLowQuality)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Stream<String > fileAsLine(){
        try{
            return Files.lines(Paths.get(pathToFile));
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}

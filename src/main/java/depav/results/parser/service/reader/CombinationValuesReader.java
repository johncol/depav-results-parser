package depav.results.parser.service.reader;

import depav.results.parser.model.Result;
import depav.results.parser.service.reader.parser.DefaultParser;
import depav.results.parser.service.reader.parser.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationValuesReader implements Reader<List<Result>> {

    private static final String POINT = ".";
    private static final String POINT_REGULAR = "\\.";

    private Parser<Path, Result> parser = new DefaultParser();

    private final String folder;

    public CombinationValuesReader(String folder) {
        this.folder = folder;
    }

    @Override
    public List<Result> read() throws IOException {
        Path path = Paths.get(folder);
        Comparator<Path> byFileName = (f1, f2) -> Comparator
                .comparing((Path file) -> file.toString().split(POINT_REGULAR)[0])
                .thenComparingInt((Path file) -> {
                    String[] parts = file.toString().split(POINT_REGULAR);
                    return new Integer(parts[parts.length - 1]);
                }).compare(f1, f2);
        return Files.walk(path)
                .filter(file -> file.toString().contains(POINT))
                .sorted(byFileName)
                .map(parser::parse)
                .collect(Collectors.toList());
    }

}


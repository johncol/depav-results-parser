package depav.results.parser.service.reader.parser;

import depav.results.parser.model.Result;
import depav.results.parser.model.Result.CombinationValuesBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultParser implements Parser<Path, Result> {

    private static final String STAR_REGEX = "\\*";

    @Override
    public Result parse(Path file) {
        try {
            List<String> lines = Files.lines(file).collect(Collectors.toList());
            return CombinationValuesBuilder.aCombinationValues()
                    .withEpsilonT(getValue(lines, 22, 4))
                    .withEpsilonZ(getValue(lines, 30, 6))
                    .withDeflection(getValue(lines, 36, 3))
                    .withRadius(getValue(lines, 37, 3))
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            return CombinationValuesBuilder.aCombinationValues().build();
        }
    }

    private String getValue(List<String> lines, int line, int location) {
        return lines.get(line - 1).split(STAR_REGEX)[location - 1].trim();
    }

}
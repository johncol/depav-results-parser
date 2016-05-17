package depav.results.parser.service.printer;

import depav.results.parser.model.Result;
import depav.results.parser.service.printer.formatter.CVSFormatter;
import depav.results.parser.service.printer.formatter.Formatter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PlainFilePrinter implements Printer {

    private final String output;
    private final List<? extends Result> results;

    public PlainFilePrinter(String output, List<? extends Result> results) {
        this.output = output;
        this.results = results;
    }

    @Override
    public void print() throws IOException {
        Path file = Paths.get(output);
        if (!Files.exists(file)) {
            file = Files.createFile(file);
        }
        Formatter formatter = new CVSFormatter();
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Result result : results) {
                writer.write(formatter.format(result));
                writer.newLine();
            }
        }
    }

}

package depav.results.parser;

import depav.results.parser.model.Result;
import depav.results.parser.model.InputData;
import depav.results.parser.service.input.DummyData;
import depav.results.parser.service.input.InputProvider;
import depav.results.parser.service.printer.PlainFilePrinter;
import depav.results.parser.service.printer.Printer;
import depav.results.parser.service.reader.ResultsReader;
import depav.results.parser.service.reader.Reader;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private InputProvider inputProvider;
    private Reader<List<Result>> reader;
    private Printer printer;

    private void run() throws IOException {
        inputProvider = getInputProvider();
        InputData inputData = inputProvider.readData();
        LOGGER.log(Level.INFO, inputData.toString());

        reader = getReader(inputData);
        List<Result> results = reader.read();
        LOGGER.log(Level.INFO, results.toString());

        printer = getPrinter(inputData, results);
        printer.print();
    }

    private InputProvider getInputProvider() {
        return new DummyData();
    }

    private Reader<List<Result>> getReader(InputData inputData) {
        return new ResultsReader(inputData.getSourceFolder());
    }

    private Printer getPrinter(InputData inputData, List<Result> results) {
        //return new ConsolePrinter(results);
        return new PlainFilePrinter(inputData.getDestinationFile(), results);
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.run();
    }

}

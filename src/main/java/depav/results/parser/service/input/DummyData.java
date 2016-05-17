package depav.results.parser.service.input;

import depav.results.parser.model.InputData;

public class DummyData implements InputProvider {

    @Override
    public InputData readData() {
        String resultsFolder = "src/main/resources/results";
        String outputFile = "target/result.csv";
        return new InputData(resultsFolder, outputFile);
    }

}

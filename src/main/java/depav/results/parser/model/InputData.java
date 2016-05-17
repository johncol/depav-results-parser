package depav.results.parser.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class InputData {

    private final String sourceFolder;
    private final String destinationFile;

    public InputData(String sourceFolder, String destinationFile) {
        this.sourceFolder = sourceFolder;
        this.destinationFile = destinationFile;
    }

    public String getDestinationFile() {
        return destinationFile;
    }

    public String getSourceFolder() {
        return sourceFolder;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

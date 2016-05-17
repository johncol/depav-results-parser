package depav.results.parser.service.reader;

import java.io.IOException;

public interface Reader<T> {
    T read() throws IOException;
}

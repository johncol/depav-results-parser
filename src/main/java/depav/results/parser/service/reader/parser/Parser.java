package depav.results.parser.service.reader.parser;

public interface Parser<T, R> {
    R parse(T file);
}

package depav.results.parser.service.printer;

import java.util.List;

public class ConsolePrinter implements Printer {

    private final List<?> elements;

    public ConsolePrinter(List<?> elements) {
        this.elements = elements;
    }

    @Override
    public void print() {
        elements.forEach(System.out::println);
    }

}

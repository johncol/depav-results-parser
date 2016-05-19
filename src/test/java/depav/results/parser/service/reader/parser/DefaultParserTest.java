package depav.results.parser.service.reader.parser;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static depav.results.parser.model.Result.ResultBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import depav.results.parser.model.Result;

@RunWith(JUnit4.class)
public class DefaultParserTest {

    private Parser<Path, Result> parser = new DefaultParser();

    @Test
    public void shouldParseResultsFile() {
        Result expectedResult = ResultBuilder.aResult()
                .withEpsilonT("-.1E-03C")
                .withEpsilonZ("-.2E-03C")
                .withDeflection("3.3MM/100")
                .withRadius("4.4M")
                .build();

        Path path = Paths.get("src/test/resources/results/test-results-file.txt");
        Result result = parser.parse(path);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(expectedResult)));
    }

}

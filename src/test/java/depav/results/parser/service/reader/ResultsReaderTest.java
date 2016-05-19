package depav.results.parser.service.reader;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static depav.results.parser.model.Result.ResultBuilder;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import depav.results.parser.model.Result;

@RunWith(JUnit4.class)
public class ResultsReaderTest {

    private static final String FOLDER = "src/test/resources/results";
    
    private ResultsReader resultsReader;

    @Test
    public void shouldReadFi() throws IOException {
        resultsReader = new ResultsReader(FOLDER);

        Result expectedResult1 = ResultBuilder.aResult()
                .withEpsilonT("-.1E-03C")
                .withEpsilonZ("-.2E-03C")
                .withDeflection("3.3MM/100")
                .withRadius("4.4M")
                .build();
        Result expectedResult2 = ResultBuilder.aResult()
                .withEpsilonT("-.5E-05C")
                .withEpsilonZ("-.6E-06C")
                .withDeflection("7.7MM/100")
                .withRadius("8.8M")
                .build();

        List<Result> results = resultsReader.read();

        assertThat(results, is(not(nullValue())));
        assertThat(results, hasSize(2));
        assertThat(results.get(0), is(equalTo(expectedResult1)));
        assertThat(results.get(1), is(equalTo(expectedResult2)));
    }

}

package depav.results.parser.service.printer.formatter;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static depav.results.parser.model.Result.ResultBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import depav.results.parser.model.Result;

@RunWith(JUnit4.class)
public class CVSFormatterTest {

    private CVSFormatter formatter = new CVSFormatter();

    @Test
    public void shouldFormatWithSemicolonMode() {
        Result result = ResultBuilder.aResult()
                .withEpsilonT("-.1E-03C")
                .withEpsilonZ("-.2E-03C")
                .withDeflection("3.3MM/100")
                .withRadius("4.4M")
                .build();

        String expectedFormattedResult = "-.1E-03;C;-.2E-03;C;3.3;4.4";

        String formattedResult = formatter.format(result);

        assertThat(formattedResult, is(equalTo(expectedFormattedResult)));
    }

    @Test
    public void shouldFormatWithCommaMode() {
        formatter.setMode(CVSFormatter.Mode.COMMA);

        Result result = ResultBuilder.aResult()
                .withEpsilonT("-.1E-03C")
                .withEpsilonZ("-.2E-03C")
                .withDeflection("3.3MM/100")
                .withRadius("4.4M")
                .build();

        String expectedFormattedResult = "-.1E-03,C,-.2E-03,C,3.3,4.4";

        String formattedResult = formatter.format(result);

        assertThat(formattedResult, is(equalTo(expectedFormattedResult)));
    }

}

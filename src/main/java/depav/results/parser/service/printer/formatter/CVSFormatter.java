package depav.results.parser.service.printer.formatter;

import depav.results.parser.model.Result;

public class CVSFormatter implements Formatter<Result> {

    enum Mode {
        COMMA(','), SEMICOLON(';'), LINE('-'), SLASH('/'), STAR('*');

        final char character;

        Mode(char character) {
            this.character = character;
        }

        public char getCharacter() {
            return character;
        }
    }

    private static final String STRING_PLACEHOLDER = "%s";

    private Mode mode = Mode.SEMICOLON;

    @Override
    public String format(Result result) {
        String epsilonT = getValue(result.getEpsilonT());
        String letterEpsilonT = getLetter(result.getEpsilonT());
        String epsilonZ =  getValue(result.getEpsilonZ());
        String letterEpsilonZ= getLetter(result.getEpsilonZ());
        String deflection = getDeflection(result.getDeflection());
        String radius = getRadius(result.getRadius());
        return String.format(getFormat(mode), epsilonT, letterEpsilonT, epsilonZ, letterEpsilonZ, deflection, radius);
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    private static String getFormat(Mode mode) {
        char c = mode.getCharacter();
        return  STRING_PLACEHOLDER + c +
                STRING_PLACEHOLDER + c +
                STRING_PLACEHOLDER + c +
                STRING_PLACEHOLDER + c +
                STRING_PLACEHOLDER + c +
                STRING_PLACEHOLDER;
    }

    private static String getValue(String value) {
        return value.substring(0, value.length() - 1);
    }

    private static String getLetter(String value) {
        return value.substring(value.length() - 1);
    }

    private static String getDeflection(String deflection) {
        return deflection.substring(0, deflection.length() - 6);
    }

    private static String getRadius(String radius) {
        return radius.substring(0, radius.length() - 1);
    }

}

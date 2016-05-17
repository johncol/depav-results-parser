package depav.results.parser.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class Result {

    private final String epsilonT;
    private final String epsilonZ;
    private final String deflection;
    private final String radius;

    private Result(String epsilonT, String epsilonZ, String deflection, String radius) {
        this.epsilonT = epsilonT;
        this.epsilonZ = epsilonZ;
        this.deflection = deflection;
        this.radius = radius;
    }

    public String getEpsilonT() {
        return epsilonT;
    }

    public String getEpsilonZ() {
        return epsilonZ;
    }

    public String getDeflection() {
        return deflection;
    }

    public String getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public static class CombinationValuesBuilder {

        private String epsilonT;
        private String epsilonZ;
        private String deflection;
        private String radius;

        private CombinationValuesBuilder() {}

        public static CombinationValuesBuilder aCombinationValues() {
            return new CombinationValuesBuilder();
        }

        public CombinationValuesBuilder withEpsilonT(String epsilonT) {
            this.epsilonT = epsilonT;
            return this;
        }

        public CombinationValuesBuilder withEpsilonZ(String epsilonZ) {
            this.epsilonZ = epsilonZ;
            return this;
        }

        public CombinationValuesBuilder withDeflection(String deflection) {
            this.deflection = deflection;
            return this;
        }

        public CombinationValuesBuilder withRadius(String radius) {
            this.radius = radius;
            return this;
        }

        public Result build() {
            return new Result(epsilonT, epsilonZ, deflection, radius);
        }

    }

}

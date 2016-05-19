package depav.results.parser.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
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

    @Override
    public int hashCode() {
        return epsilonT.hashCode() * 3
                + epsilonZ.hashCode() * 5
                + deflection.hashCode() * 7
                + radius.hashCode() * 11;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        return new EqualsBuilder()
                .append(epsilonT, other.epsilonT)
                .append(epsilonZ, other.epsilonZ)
                .append(deflection, other.deflection)
                .append(radius, other.radius)
                .build();
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

    public static class ResultBuilder {

        private String epsilonT;
        private String epsilonZ;
        private String deflection;
        private String radius;

        private ResultBuilder() {}

        public static ResultBuilder aResult() {
            return new ResultBuilder();
        }

        public ResultBuilder withEpsilonT(String epsilonT) {
            this.epsilonT = epsilonT;
            return this;
        }

        public ResultBuilder withEpsilonZ(String epsilonZ) {
            this.epsilonZ = epsilonZ;
            return this;
        }

        public ResultBuilder withDeflection(String deflection) {
            this.deflection = deflection;
            return this;
        }

        public ResultBuilder withRadius(String radius) {
            this.radius = radius;
            return this;
        }

        public Result build() {
            return new Result(epsilonT, epsilonZ, deflection, radius);
        }

    }

}

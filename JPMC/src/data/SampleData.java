package data;

import java.math.BigDecimal;

/**
 * Data structure to hold sample data
 */
public class SampleData {

    private String type;
    private BigDecimal lastDividend;
    private BigDecimal fixedDividend;
    private BigDecimal parValue;

    /**
     * Constructor
     * @param type
     * @param lastDividend
     * @param fixedDividend
     * @param parValue
     */
    public SampleData(final String type, final BigDecimal lastDividend,
                      final BigDecimal fixedDividend, final BigDecimal parValue) {

        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }

    public String getType() {
        return this.type;
    }

    public BigDecimal getLastDividend() {
        return this.lastDividend;
    }

    public BigDecimal getFixedDividend() {
        return this.fixedDividend;
    }

    public BigDecimal getParValue() {
        return this.parValue;
    }

}

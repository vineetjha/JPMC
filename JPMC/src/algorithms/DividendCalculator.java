package algorithms;

import data.Data;
import data.SampleData;
import resources.DividendConstants;
import resources.ErrorConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/**
 * Algorithms for dividend calculations
 */
public class DividendCalculator {

    /**
     * Method to calculate COMMON dividend
     * @param lastDividend
     * @param price
     * @return
     */
    private static BigDecimal commonDividend(final BigDecimal lastDividend, final BigDecimal price) {

        return lastDividend.divide(price, 2, RoundingMode.CEILING);
    }

    /**
     * Method to calculate PREFERRED dividend
     * @param fixedDividend
     * @param parValue
     * @param price
     * @return
     */
    private static BigDecimal preferredDividend(final BigDecimal fixedDividend, final BigDecimal parValue, final BigDecimal price) {

        return fixedDividend.multiply(parValue).divide(price, 2, RoundingMode.CEILING);
    }

    /**
     * Calculate dividend
     * @param stockSymbol
     * @param price
     * @return
     * @throws InvalidAlgorithmParameterException
     */
    public static BigDecimal calculateDividend(final String stockSymbol, final BigDecimal price) throws InvalidAlgorithmParameterException {

        SampleData relevantData = Data.getData(stockSymbol);
        if (Objects.equals(relevantData.getType().toUpperCase(), DividendConstants.COMMON)) {
            return commonDividend(relevantData.getLastDividend(), price);
        } else if (Objects.equals(relevantData.getType().toUpperCase(), DividendConstants.PREFERRED)) {
            return preferredDividend(relevantData.getFixedDividend(), relevantData.getParValue(), price);
        } else {
            throw new InvalidAlgorithmParameterException(ErrorConstants.INVALID_INDICATOR);
        }
    }
}
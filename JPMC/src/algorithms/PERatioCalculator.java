package algorithms;

import resources.ErrorConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidAlgorithmParameterException;

/**
 * Algorithm to calculate P/E ratio
 */
public class PERatioCalculator {

    /**
     * Method to calculate P/E ratio
     * @param stockSymbol
     * @param price
     * @return
     * @throws InvalidAlgorithmParameterException
     */
    public static BigDecimal calculatePERatio(final String stockSymbol, final BigDecimal price) throws InvalidAlgorithmParameterException {

        final BigDecimal dividend = DividendCalculator.calculateDividend(stockSymbol, price);
        if (dividend.compareTo(BigDecimal.ZERO)==0) {
            throw new ArithmeticException(ErrorConstants.DIVIDE_BY_ZERO);
        }
        return price.divide(DividendCalculator.calculateDividend(stockSymbol, price), 2, RoundingMode.CEILING);
    }

}

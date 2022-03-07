package validations;

import java.util.Objects;

import resources.ErrorConstants;
import resources.TradeConstants;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Trade validation to filter out invalid trade entries, could be extended to add more checks
 */
public class TradeValidation {

    /**
     * Timestamp should be in past
     * @param timestamp
     */
    protected static void validateTimestamp(final LocalDateTime timestamp) {

        if (timestamp.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_TIMESTAMP);
        }
    }

    /**
     * Either But or Sell only
     * @param indicator
     */
    protected static void validateIndicator(final String indicator) {

        if (!Objects.equals(indicator, TradeConstants.BUY_INDICATOR)
                && !Objects.equals(indicator, TradeConstants.SELL_INDICATOR)) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_INDICATOR);
        }
    }

    /**
     * Price cannot be negative
     * @param price
     */
    protected static void validatePrice(final BigDecimal price) {

        if (price==null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_PRICE);
        }
        // https://www.bbc.com/news/business-52350082
        if (price.compareTo(BigDecimal.ZERO)<=0) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_PRICE);
        }
    }

    /**
     * Quantity should be greater than zero
     * @param quantity
     */
    protected static void validateQuantity(final int quantity) {

        if (quantity<=0) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_QUANTITY);
        }
    }

    /**
     * Carry out validations
     * @param timestamp
     * @param indicator
     * @param price
     * @param quantity
     */
    public static void validate(final LocalDateTime timestamp, final String indicator, final BigDecimal price, final int quantity) {

        validateTimestamp(timestamp);
        validateIndicator(indicator);
        validatePrice(price);
        validateQuantity(quantity);
    }

}

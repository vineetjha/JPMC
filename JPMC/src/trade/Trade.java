package trade;

import validations.TradeValidation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data structure to hold trades
 */
public class Trade {

    private LocalDateTime timestamp;
    private String indicator;
    private BigDecimal price;
    private int quantity;

    /**
     * Constructor
     * @param timestamp
     * @param indicator
     * @param price
     * @param quantity
     */
    public Trade(final LocalDateTime timestamp, final String indicator, final BigDecimal price, final int quantity) {

        // Restrict from creating invalid trade
        TradeValidation.validate(timestamp, indicator, price, quantity);
        this.timestamp = timestamp;
        this.indicator = indicator;
        this.price = price;
        this.quantity = quantity;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public String getIndicator() {
        return this.indicator;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

}

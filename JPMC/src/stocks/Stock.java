package stocks;

import algorithms.DividendCalculator;
import algorithms.PERatioCalculator;
import algorithms.VolumeWeightedPrice;
import resources.ErrorConstants;
import trade.Trade;

import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Stores and calculates/retrieves all relevant data for a particular stock
 */
public class Stock {

    private String stockName;
    private String stockSymbol;
    private List<Trade> trades;

    /**
     * Create new stock
     * @param stockName
     * @param stockSymbol
     */
    public Stock(final String stockName, final String stockSymbol) {

        if (Objects.equals(stockSymbol, null) || Objects.equals(stockSymbol, "")) {
            throw new IllegalArgumentException(ErrorConstants.STOCK_ID_UNAVAILABLE);
        }

        if (Objects.equals(stockName, null) || Objects.equals(stockName, "")) {
            throw new IllegalArgumentException(ErrorConstants.STOCK_NAME_UNAVAILABLE);
        }

        this.stockSymbol = stockSymbol;
        this.stockName = stockName;
        trades = new ArrayList<>();
    }

    /**
     * Calculate dividend yield for given price
     * @param price
     * @return
     * @throws InvalidAlgorithmParameterException
     */
    public BigDecimal calculateDividendYield(final BigDecimal price) throws InvalidAlgorithmParameterException {

        return DividendCalculator.calculateDividend(stockSymbol, price);
    }

    /**
     * Calculate P/E ratio for given price
     * @param price
     * @return
     * @throws InvalidAlgorithmParameterException
     */
    public BigDecimal calculatePERatio(final BigDecimal price) throws InvalidAlgorithmParameterException {

        return PERatioCalculator.calculatePERatio(stockSymbol, price);
    }

    /**
     * Record new trade
     * @param timestamp
     * @param quantity
     * @param indicator
     * @param price
     */
    public void recordTrade(final LocalDateTime timestamp, final int quantity, final String indicator, final BigDecimal price) {

        Trade trade = new Trade(timestamp, indicator, price, quantity);
        System.out.println("Adding new trade : " + trade.getTimestamp() + ", " + trade.getQuantity() + ", " + trade.getIndicator() + ", " + trade.getPrice());
        trades.add(trade);
    }

    /**
     * Calculate volume weighted price
     * @return
     */
    public BigDecimal calculateVolumeWeightedPrice() {

        return VolumeWeightedPrice.calculateVolumeWeightedPrice(this.trades);
    }

    public String getStockSymbol() {

        return this.stockSymbol;
    }

    public String getStockName() {

        return this.stockName;
    }

    public List<Trade> getTrades() {

        return this.trades;
    }

}

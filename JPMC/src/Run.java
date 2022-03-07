import data.Data;
import resources.TradeConstants;
import stocks.Stock;

import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Runner class
 */
public class Run {

    private static List<Stock> stocks;

    public static void addSampleData() {

        Data data = new Data();
        data.addData("TEA", "Common", BigDecimal.valueOf(1), null, BigDecimal.valueOf(100));
        // .
        // .
        // ... Add rest of it here
    }

    public static BigDecimal calculateAllShareIndex() {

        BigDecimal allShareIndex = BigDecimal.ONE;
        for (Stock stock : stocks) {
            allShareIndex = allShareIndex.multiply(stock.calculateVolumeWeightedPrice());
        }
        return allShareIndex.pow(1/stocks.size());
    }

    public static void main(String args[]) throws InvalidAlgorithmParameterException {

        stocks = new ArrayList<>();

        // Pouplate sample data
        addSampleData();

        stocks.add( new Stock("TEA", "TEA"));

        Stock stock = stocks.get(0);
        stock.recordTrade(LocalDateTime.now().minusMinutes(1), 100, TradeConstants.BUY_INDICATOR, BigDecimal.valueOf(12.5));
        System.out.println(String.format("Dividend yield for %s : ", stock.getStockSymbol()) + stock.calculateDividendYield(BigDecimal.ONE));
        System.out.println(String.format("P/E ratio for %s : ", stock.getStockSymbol()) + stock.calculatePERatio(BigDecimal.valueOf(10)));
        System.out.println("All share index : " + calculateAllShareIndex());
    }

}

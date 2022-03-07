package data;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Stores list of sample data
 */
public class Data {

    private static HashMap<String, SampleData> sampleData;

    public Data() {
        sampleData = new HashMap<>();
    }

    /**
     * Add new sample data (stock)
     * @param stockSymbol
     * @param type
     * @param lastDividend
     * @param fixedDividend
     * @param parValue
     */
    public void addData(final String stockSymbol, final String type, final BigDecimal lastDividend,
                        final BigDecimal fixedDividend, final BigDecimal parValue) {

        SampleData data = new SampleData(type, lastDividend, fixedDividend, parValue);
        if (!sampleData.containsKey(stockSymbol)) {
            sampleData.remove(stockSymbol);
        }
        sampleData.put(stockSymbol, data);
    }

    /**
     * Get stock data based on stock symbol
     * @param stockSymbol
     * @return
     */
    public static SampleData getData(final String stockSymbol) {

        return sampleData.get(stockSymbol);
    }

}

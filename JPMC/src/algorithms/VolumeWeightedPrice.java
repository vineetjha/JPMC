package algorithms;

import trade.Trade;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Algorithm to calculate Volume weighted price
 */
public class VolumeWeightedPrice {

    /**
     * Method to calculate Volume weighted price
     * @param trades
     * @return
     */
    public static BigDecimal calculateVolumeWeightedPrice(final List<Trade> trades) {

        BigDecimal weightedSum = BigDecimal.valueOf(0);
        BigDecimal quantitySum = BigDecimal.valueOf(0);
        LocalDateTime curr = LocalDateTime.now();
        LocalDateTime currMinus5min = curr.minusMinutes(5);
        for (int idx = trades.size()-1; idx>=0; idx--) {
            if (trades.get(idx).getTimestamp().isBefore(currMinus5min)) {
                break;
            }
            weightedSum = weightedSum.add(trades.get(idx).getPrice().multiply(BigDecimal.valueOf(trades.get(idx).getQuantity())));
            quantitySum = quantitySum.add(BigDecimal.valueOf(trades.get(idx).getQuantity()));
        }

        if (quantitySum.compareTo(BigDecimal.ZERO)==0) {
            return BigDecimal.ZERO;
        } else {
            return weightedSum.divide(quantitySum, 2, RoundingMode.CEILING);
        }
    }

}

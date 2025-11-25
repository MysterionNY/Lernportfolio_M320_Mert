package V3A;

import java.util.HashMap;
import java.util.Map;

public class ZurichStockExchange implements StockExchange {

    private Map<String, Double> prices = new HashMap<>();

    // Preise in CHF
    public ZurichStockExchange() {
        prices.put("Microsoft", 120.0);
        prices.put("Apple", 140.0);
        prices.put("Tesla", 80.0);
    }

    @Override
    public double getPrice(String stockName) {
        return prices.getOrDefault(stockName, 0.0);
    }

    @Override
    public String getName() {
        return "Zürich";
    }
}


package V3A;

import java.util.HashMap;
import java.util.Map;

public class NewYorkStockExchange implements StockExchange {

    private Map<String, Double> prices = new HashMap<>();

    // Preise in USD
    public NewYorkStockExchange() {
        prices.put("Microsoft", 100.0);
        prices.put("Apple", 110.0);
        prices.put("Tesla", 90.0);
    }

    @Override
    public double getPrice(String stockName) {
        return prices.getOrDefault(stockName, 0.0);
    }

    @Override
    public String getName() {
        return "New York";
    }
}

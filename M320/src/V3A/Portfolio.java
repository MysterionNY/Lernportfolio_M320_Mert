package V3A;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    /**
     * Berechnet den Gesamtwert des Portfolios an einer bestimmten Börse.
     */
    public double calculateTotalValue(StockExchange exchange) {
        double sum = 0.0;
        for (Stock s : stocks) {
            double price = exchange.getPrice(s.getName());
            sum += price * s.getAmount();
        }
        return sum;
    }

    public void printStocks() {
        System.out.println("Aktien im Portfolio:");
        for (Stock s : stocks) {
            System.out.println(" - " + s);
        }
    }
}

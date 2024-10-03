import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverterApp {

    private static Map<String, Double> exchangeRates = new HashMap<>();
    static {
        exchangeRates.put("USD_EUR", 0.85); // 1 USD = 0.85 EUR
        exchangeRates.put("EUR_USD", 1.18); // 1 EUR = 1.18 USD
        exchangeRates.put("USD_INR", 74.50); // 1 USD = 74.50 INR
        exchangeRates.put("INR_USD", 0.013); // 1 INR = 0.013 USD
        exchangeRates.put("EUR_INR", 87.50); // 1 EUR = 87.50 INR
        exchangeRates.put("INR_EUR", 0.011); // 1 INR = 0.011 EUR
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Currency Converter ---");

        System.out.print("Enter base currency (e.g., USD, EUR, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., USD, EUR, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        if (convertedAmount != -1) {
            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Conversion rate not found or invalid currency pair.");
        }

        scanner.close();
    }

    public static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        String key = baseCurrency + "_" + targetCurrency;

        if (exchangeRates.containsKey(key)) {
            double rate = exchangeRates.get(key);
            return amount * rate;
        } else {
            return -1;
        }
    }
}

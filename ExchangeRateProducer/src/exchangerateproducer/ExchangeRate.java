package exchangerateproducer;

import java.util.Scanner;

public interface ExchangeRate {
	
	public void add(String countryCode, Double rate);
	public void update(String countryCode, Double rate);
	public void delete(String countryCode);
	public float get(String countryCode);
	void initializeExchangeRates();
	void setFromCurrency();
	void setToCurrency();
	public double getExchangeRate();
	public void setExchangeRate();
	public Scanner getScanner();
	public String getCountryCode();
}

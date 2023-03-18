package exchangerateproducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExchangeRateImpl implements ExchangeRate {
	
	private String fromCurrency;
	
	private String toCurrency;
	
	private String countryCode;
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	private Scanner scanner = new Scanner(System.in);
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public Scanner getScanner() {
		return scanner;
	}

	private Map<String,Double> exchangeRates;
	
	
	private double exchangeRate;

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate() {
		this.countryCode = this.fromCurrency +"-"+this.toCurrency;
		this.exchangeRate = exchangeRates.get(countryCode);
		System.out.println(this.exchangeRate);
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency() {
		System.out.println("setting from currency");
	    System.out.print("Enter the country code: ");
	    String userInput;
		try {
			userInput = reader.readLine();
			this.fromCurrency = userInput;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency() {
		System.out.println("setting to currency");
	    System.out.print("Enter the country code: ");
	    String userInput;
	    try {
			userInput = reader.readLine();
			this.toCurrency = userInput;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void initializeExchangeRates() {
		System.out.println("Initializing exchange rates");
		exchangeRates = new HashMap<>();
		exchangeRates.put("LKR-USD",0.0030);
		exchangeRates.put("LKR-GBP",0.0025);
		exchangeRates.put("LKR-EUR",0.0028);
		exchangeRates.put("LKR-JPY",0.41);
	}
	
	@Override
	public void add(String countryCode, Double rate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String countryCode, Double rate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String countryCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float get(String countryCode) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package exchangerateproducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

import java.net.http.*;
import java.net.URI;

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

	private Map<String, Double> exchangeRates;

	private double exchangeRate;

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate() {
		this.countryCode = this.fromCurrency + "-" + this.toCurrency;
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
	
	String APP_ID = "cb7087c197064b40b5df73dea178bfe0";
	
	public void initializeExchangeRates() {
		System.out.println("Initializing exchange rates");
		exchangeRates = new HashMap<>();
		exchangeRates.put("LKR-USD", 0.0030);
		exchangeRates.put("LKR-GBP", 0.0025);
		exchangeRates.put("LKR-EUR", 0.0028);
		exchangeRates.put("LKR-JPY", 0.41);

		try {
			// Get exchange rates from the openexchangerates.org when available
			HttpRequest.Builder builder = HttpRequest.newBuilder();
			builder.uri(
					new URI("https://openexchangerates.org/api/latest.json?app_id=" + APP_ID));
			builder.GET();
			HttpRequest request = builder.build();
			HttpClient client = HttpClient.newHttpClient();
			HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

			String jsonString = response.body().toString();
			ExchangeRateAPIResponse res = new Gson().fromJson(jsonString, ExchangeRateAPIResponse.class);

			for (Map.Entry<String, Double> entry : res.getRates().entrySet()) {
				exchangeRates.put(res.getBase() + "-" + entry.getKey(), entry.getValue());
			}
			
			System.out.println(exchangeRates);
		} catch (Exception e) {
			System.out.println("Error in Exchange rate API\n");
			e.printStackTrace();
		}
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

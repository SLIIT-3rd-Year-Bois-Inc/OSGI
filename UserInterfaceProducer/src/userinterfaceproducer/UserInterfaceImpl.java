package userinterfaceproducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterfaceService {
	
	private String countryCode;
	private double valueForConversion;
	private String userInputForHistoricalData;
	private String startDateForFluctuation;
	private String endDateForFluctuation;
	private Scanner scanner;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getUserInputForHistoricalData() {
		return userInputForHistoricalData;
	}

	public void setUserInputForHistoricalData() {
		System.out.println("Getting user input for historical data");
		System.out.print("Enter the date:");
		String userInput;
		try {
			userInput = reader.readLine();
			this.userInputForHistoricalData = userInput;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public String getStartDateForFluctuation() {
		return startDateForFluctuation;
	}

	public void setStartDateForFluctuation() {
		System.out.println("Getting user input fluctuation");
		System.out.print("Enter the start date for fluctuation:");
		String userInput;
		try {
			userInput = reader.readLine();
			this.startDateForFluctuation = userInput;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public String getEndDateForFluctuation() {
		return endDateForFluctuation;
	}

	public void setEndDateForFluctuation() {
		System.out.print("Enter the end date for fluctuation:");
		String userInput;
		try {
			userInput = reader.readLine();
			this.endDateForFluctuation = userInput;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getValue() {
		return this.valueForConversion;
	}

	public void setValueForConversion() {
		System.out.println("Getting user input");
		System.out.print("Enter the value:");
		String userInput;
		try {
			userInput = reader.readLine();
			this.valueForConversion = Double.parseDouble(userInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	

	
}

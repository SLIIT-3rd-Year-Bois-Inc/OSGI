package userinterfaceproducer;

import java.util.Scanner;

public interface UserInterfaceService {
	public String getCountryCode();
	public double getValue();
	public void setValueForConversion();
	public void setScanner(Scanner scanner);
	public void setUserInputForHistoricalData();
	public void setStartDateForFluctuation();
	public void setEndDateForFluctuation();
	public String getStartDateForFluctuation();
	public String getEndDateForFluctuation();
	public String getUserInputForHistoricalData();
	public Scanner getScanner();
}

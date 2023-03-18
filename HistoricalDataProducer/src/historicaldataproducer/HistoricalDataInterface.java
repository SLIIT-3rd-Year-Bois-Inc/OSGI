package historicaldataproducer;
import java.util.Scanner;

public interface HistoricalDataInterface {
	
	public double getHistoricalData(String date,String countryCode);
	public void initializeHistoricalData();

}

package historicaldataproducer;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


public class HistoricalDataImpl implements HistoricalDataInterface{
 
	private Map<Key,Double> historicalData;
	
	public double getHistoricalData(String date,String countryCode) {
		System.out.println(date + " " + countryCode);
		System.out.println(historicalData.get(new Key(countryCode,date)));
		return historicalData.get(new Key(countryCode,date));
	}
	
	public void initializeHistoricalData() {
		System.out.println("Initializing historical data");
		historicalData = new TreeMap<>(new Comparator<Key>() {

			@Override
			public int compare(Key k1, Key k2) {
				if(k1.getCountryCode().equals(k2.getCountryCode())&&k1.getDate().equals(k2.getDate())) {
					return 0;
				}
				return -1;
			}
		});
		Key key1 = new Key("LKR-USD","oct-31-2022");
		Key key2 = new Key("LKR-USD","nov-30-2022");
		Key key3 = new Key("LKR-USD","dec-31-2022");
		Key key4 = new Key("LKR-USD","jan-31-2023");
		Key key5 = new Key("LKR-USD","feb-28-2023");
		historicalData.put(key1, 0.635892);
		historicalData.put(key2, 0.661812);
		historicalData.put(key3, 0.674747);
		historicalData.put(key4, 0.695193);
		historicalData.put(key5, 0.688502);
	}

}

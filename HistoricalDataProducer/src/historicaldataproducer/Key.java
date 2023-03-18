package historicaldataproducer;

public class Key {

	private String countryCode;
	private String date;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Key(String countryCode, String date) {
		super();
		this.countryCode = countryCode;
		this.date = date;
	}
}

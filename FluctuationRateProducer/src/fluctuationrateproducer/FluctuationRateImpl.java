package fluctuationrateproducer;

public class FluctuationRateImpl implements FluctuationRateInterface{

	public void calculateFluctuation(double beginningExchangeRate,double endingExchangeRate) {
		System.out.println("Calculating fluctuation rate");
		double fluctuation = (endingExchangeRate - beginningExchangeRate) / beginningExchangeRate * 100.0;
		System.out.println(fluctuation);
	}
}

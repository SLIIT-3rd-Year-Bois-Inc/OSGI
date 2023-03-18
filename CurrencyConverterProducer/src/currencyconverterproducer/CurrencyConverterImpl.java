package currencyconverterproducer;

import exchangerateproducer.ExchangeRate;

public class CurrencyConverterImpl implements CurrencyConverterInterface{

	@Override
	public float convert(ExchangeRate ex,double value) {
		// TODO Auto-generated method stub
		System.out.println("converting");
		double conversion = ex.getExchangeRate() * value;
		System.out.println(conversion);
		return 0;
	}

}

package exchangeratecrudproducer;

import exchangerateproducer.ExchangeRate;

public interface ExchangeRateCrudInterface {

	public void add(ExchangeRate ex);
	public void update(ExchangeRate ex);
	public void delete(ExchangeRate ex);
}

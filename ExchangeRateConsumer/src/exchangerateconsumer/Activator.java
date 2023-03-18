package exchangerateconsumer;

import exchangerateproducer.ExchangeRate;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference serviceReference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Exchange Rate Consumer Started");
		serviceReference  = context.getServiceReference(ExchangeRate.class.getName());
		ExchangeRate exc = (ExchangeRate) context.getService(serviceReference);
		exc.initializeExchangeRates();
		exc.setFromCurrency();
		exc.setToCurrency();
		exc.setExchangeRate();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}

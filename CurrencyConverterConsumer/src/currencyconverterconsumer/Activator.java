package currencyconverterconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import currencyconverterproducer.CurrencyConverterInterface;
import exchangerateproducer.ExchangeRate;
import userinterfaceproducer.UserInterfaceService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference serviceReference;
	private ServiceReference currencyConverterServiceRef;
	private ServiceReference exchangeRateServiceRef;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Currency Converter Consumer Started");
		serviceReference = context.getServiceReference(UserInterfaceService.class.getName());
		UserInterfaceService userService = (UserInterfaceService) context.getService(serviceReference);
		exchangeRateServiceRef  = context.getServiceReference(ExchangeRate.class.getName());
		ExchangeRate exchangeRateService = (ExchangeRate) context.getService(exchangeRateServiceRef);
		currencyConverterServiceRef = context.getServiceReference(CurrencyConverterInterface.class.getName());
		CurrencyConverterInterface converterService = (CurrencyConverterInterface) context.getService(currencyConverterServiceRef);
		converterService.convert(exchangeRateService, userService.getValue());
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}

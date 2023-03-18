package historicaldataconsumer;

import historicaldataproducer.HistoricalDataInterface;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import exchangerateproducer.ExchangeRate;
import userinterfaceproducer.UserInterfaceService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference serviceReference;
	private ServiceReference userInterfaceServiceReference;
	private ServiceReference exchangeRateServiceRef;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		userInterfaceServiceReference = context.getServiceReference(UserInterfaceService.class.getName());
		UserInterfaceService userService = (UserInterfaceService) context.getService(userInterfaceServiceReference);
		serviceReference = context.getServiceReference(HistoricalDataInterface.class.getName());
		HistoricalDataInterface hist = (HistoricalDataInterface) context.getService(serviceReference);
		hist.initializeHistoricalData();
		exchangeRateServiceRef = context.getServiceReference(ExchangeRate.class.getName());
		ExchangeRate rate = (ExchangeRate) context.getService(exchangeRateServiceRef);
		System.out.println(hist.getHistoricalData(userService.getUserInputForHistoricalData(), rate.getCountryCode()));
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}

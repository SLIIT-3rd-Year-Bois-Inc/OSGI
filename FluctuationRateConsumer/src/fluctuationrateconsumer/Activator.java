package fluctuationrateconsumer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import exchangerateproducer.ExchangeRate;
import fluctuationrateproducer.FluctuationRateInterface;
import historicaldataproducer.HistoricalDataInterface;
import userinterfaceproducer.UserInterfaceService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference serviceReference;
	private ServiceReference userInterfaceServiceReference;
	private ServiceReference historicalDataServiceRef;
	private ServiceReference exchangeRateServiceRef;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Fluctuation Rate Consumer Started");
		serviceReference  = context.getServiceReference(FluctuationRateInterface.class.getName());
		userInterfaceServiceReference = context.getServiceReference(UserInterfaceService.class.getName());
		UserInterfaceService userService = (UserInterfaceService) context.getService(userInterfaceServiceReference);
		FluctuationRateInterface flu = (FluctuationRateInterface) context.getService(serviceReference);
		historicalDataServiceRef  = context.getServiceReference(HistoricalDataInterface.class.getName());
		HistoricalDataInterface exc = (HistoricalDataInterface) context.getService(historicalDataServiceRef);
		exchangeRateServiceRef = context.getServiceReference(ExchangeRate.class.getName());
		ExchangeRate rate = (ExchangeRate) context.getService(exchangeRateServiceRef);
		flu.calculateFluctuation(exc.getHistoricalData(userService.getStartDateForFluctuation(),rate.getCountryCode()), exc.getHistoricalData(userService.getEndDateForFluctuation(),rate.getCountryCode()));
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}

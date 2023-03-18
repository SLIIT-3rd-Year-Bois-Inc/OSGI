package userinterfaceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import exchangerateproducer.ExchangeRate;
import fluctuationrateproducer.FluctuationRateInterface;
import historicaldataproducer.HistoricalDataInterface;
import userinterfaceproducer.UserInterfaceService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference serviceReference;
	private ServiceReference exchangeRateServiceRef;
	private ServiceReference historicalDataServiceRef;
	private ServiceReference fluctuationRateServiceRef;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("User Interface Consumer Started");
		serviceReference = context.getServiceReference(UserInterfaceService.class.getName());
		UserInterfaceService service = (UserInterfaceService) context.getService(serviceReference);
		exchangeRateServiceRef = context.getServiceReference(ExchangeRate.class.getName());
		ExchangeRate exchangeRateService = (ExchangeRate) context.getService(exchangeRateServiceRef);
		historicalDataServiceRef = context.getServiceReference(HistoricalDataInterface.class.getName());
		fluctuationRateServiceRef = context.getServiceReference(FluctuationRateInterface.class.getName());
		HistoricalDataInterface hist = (HistoricalDataInterface) context.getService(historicalDataServiceRef);
		hist.initializeHistoricalData();
		service.setValueForConversion();
		if(fluctuationRateServiceRef != null && historicalDataServiceRef != null) {
			service.setUserInputForHistoricalData();
			service.setStartDateForFluctuation();
			service.setEndDateForFluctuation();
		}
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}

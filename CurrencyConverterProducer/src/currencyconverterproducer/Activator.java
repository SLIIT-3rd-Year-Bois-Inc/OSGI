package currencyconverterproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	ServiceRegistration publishServiceRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.print("Currency Converter Publisher Started");
		CurrencyConverterImpl impl = new CurrencyConverterImpl();
		publishServiceRegistration = context.registerService(CurrencyConverterInterface.class.getName(),impl,null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.print("Currency Converter Publisher Stoped");
		publishServiceRegistration.unregister();
	}

}

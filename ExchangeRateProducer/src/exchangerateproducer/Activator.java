package exchangerateproducer;

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
		System.out.println("Exchange Rate Producer Started");
		ExchangeRate impl = new ExchangeRateImpl();
		publishServiceRegistration = context.registerService(ExchangeRate.class.getName(),impl, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Exchange Rate Producer Stopped");
		publishServiceRegistration.unregister();
	}

}

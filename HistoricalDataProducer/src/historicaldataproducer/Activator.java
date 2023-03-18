package historicaldataproducer;

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
		System.out.println("Historical Data Producer Started");
		HistoricalDataInterface impl = new HistoricalDataImpl();
		publishServiceRegistration = context.registerService(HistoricalDataInterface.class.getName(),impl, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		publishServiceRegistration.unregister();
	}

}

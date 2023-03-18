package fluctuationrateproducer;
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
		System.out.println("Fluctuation Rate Producer Started");
		FluctuationRateInterface impl = new FluctuationRateImpl();
		publishServiceRegistration = context.registerService(FluctuationRateInterface.class.getName(),impl, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}

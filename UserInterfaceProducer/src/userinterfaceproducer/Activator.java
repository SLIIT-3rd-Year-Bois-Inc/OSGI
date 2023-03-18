package userinterfaceproducer;

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
		System.out.print("User Interface Publisher Started");
		UserInterfaceService impl = new UserInterfaceImpl();
		publishServiceRegistration = context.registerService(UserInterfaceService.class.getName(),impl,null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.print("User Interface Publisher Stoped");
		publishServiceRegistration.unregister();
	}

}

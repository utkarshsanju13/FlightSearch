package configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.FlightDetails;

public class DBConfigure {
	private static SessionFactory sessionFactory;
	
	private DBConfigure() {
	}

	/**
	 * configuration of the hibernate and creates the database of the Flight class
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(FlightDetails.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}

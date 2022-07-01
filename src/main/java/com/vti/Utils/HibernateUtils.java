package com.vti.Utils;

import com.vti.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;

	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	private HibernateUtils() {
		configure();
	}

	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Product.class);
	}

	private void sessionFactoryBuild() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder();

			StandardServiceRegistryBuilder serviceRegistry2 = serviceRegistry.applySettings(configuration.getProperties());

			ServiceRegistry serviceRegistry3 = serviceRegistry2.build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry3);
		}

	}

	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	public Session openSession() {
		sessionFactoryBuild();
		return sessionFactory.openSession();
	}
}

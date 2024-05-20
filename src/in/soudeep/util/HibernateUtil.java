package in.soudeep.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.soudeep.dataobjects.Employee;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	static {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
								 .configure()
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		}
	}
	
	public static Session getSession() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}

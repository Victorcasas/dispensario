package paco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SocioDAO {
	void save(Socio socio) {
	try {
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sf=configuration.buildSessionFactory(sr);
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(socio);
		ss.getTransaction().commit();
		ss.close();
	} catch (Exception e) {
		System.out.println();
	}
	System.out.println("<---End--->");
	}
}


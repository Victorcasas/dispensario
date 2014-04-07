package org.onedreamcsc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class VariedadDAO {
	private List<Variedad> variedades;

	public List<Variedad> getVariedades() {
		return variedades;
	}

	public void setVariedades(List<Variedad> variedades) {
		this.variedades = variedades;
	}

	void save(Variedad variedad) {
	try {
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sf=configuration.buildSessionFactory(sr);
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.saveOrUpdate(variedad);
		ss.getTransaction().commit();
		ss.close();
	} catch (Exception e) {
		System.out.println("<---Exception--->");
	}
	System.out.println("<---End--->");
	}

	public Variedad load(int id) {
		Variedad variedad = null;
		try {
			Configuration configuration=new Configuration();
			configuration.configure();
			ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sf=configuration.buildSessionFactory(sr);
			Session ss = sf.openSession();
			ss.beginTransaction();
			variedad = (Variedad) ss.byId(Variedad.class).load(id);
			ss.getTransaction().commit();
			ss.close();
		} catch (Exception e) {
			System.out.println("<---Exception--->");
		}
		System.out.println("<---End--->");
		return variedad;
		}

	@SuppressWarnings("unchecked")
	public Variedad load(String nombre) {
		Variedad variedad = null;
		try {
			Configuration configuration=new Configuration();
			configuration.configure();
			ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sf=configuration.buildSessionFactory(sr);
			Session ss = sf.openSession();
			ss.beginTransaction();
			List<Integer> ids = ss.createSQLQuery("select variedadId from Variedad_table where Variedad = '"+nombre+"'").list();        
			for (int id:ids) {
				variedad=(Variedad) ss.byId( Variedad.class ).load(id);
				System.out.println("variedad name: "+variedad.getVariedadNombre());
			}
			ss.saveOrUpdate(variedad);
			ss.getTransaction().commit();
			ss.close();
		} catch (Exception e) {
			System.out.println("<---Exception--->");
		}
		System.out.println("<---End--->");
		return variedad;
		}

	@SuppressWarnings("unchecked")
	public List<Variedad> list() {
		Variedad variedad = null;
		setVariedades(new ArrayList<Variedad>());
		try {
			Configuration configuration=new Configuration();
			configuration.configure();
			ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sf=configuration.buildSessionFactory(sr);
			Session ss = sf.openSession();
			ss.beginTransaction();
			List<Integer> ids = ss.createSQLQuery("select variedadId from Variedad_table").list();        
			for (int id:ids) {
				variedad=(Variedad) ss.byId( Variedad.class ).load(id);
				getVariedades().add(variedad);
				ss.saveOrUpdate(variedad);
			}
			
			ss.getTransaction().commit();
			ss.close();
		} catch (Exception e) {
			System.out.println("<---Exception--->");
		}
		System.out.println("<---End--->");
		return getVariedades();
	}
	
}
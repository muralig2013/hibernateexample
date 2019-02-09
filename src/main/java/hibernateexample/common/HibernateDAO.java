package hibernateexample.common;

import org.hibernate.Session;

public class HibernateDAO {
	
	protected Session session;
	
	public HibernateDAO(Session session) {
		this.session = session;
	}
	
	public void attachDirty(Object instance) {
		try {
			session.saveOrUpdate(instance);
		} catch (Exception ex) {
			System.out.println("Exception occured" + ex);
		}
	}

	public void delete(Object persistentInstance) {
		try {
			session.delete(persistentInstance);
		} catch (Exception ex) {
			System.out.println("Exception occured" + ex);
		}
	}

	public Object findById(long id, Class runtimeClass) {
		System.out.println("findById Object instance with id: " + id);
		try {
			Object instance = session.get(runtimeClass, new Long(id));
			if (instance == null) {
				System.out.println("findById successful, no instance found");
			} else {
				System.out.println("findById successful, instance found");
			}
			return instance;
		} catch (Exception ex) {
			System.out.println("Exception occured" + ex);
		}
		return null;
	}

	public void persist(Object transientInstance) {
		System.out.println("persisting Object instance");
		try {
			session.persist(transientInstance);
			System.out.println("persist successful");
		} catch (Exception ex) {
			System.out.println("Exception occured" + ex);
		}
	}
}

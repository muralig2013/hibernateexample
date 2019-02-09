package hibernateexample.common;

import hibernateexample.Utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class HibernateManager {
	
	public Session initSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	public Session initTransaction() {
		Session session = initSession();
		session.beginTransaction();
		return session;
	}
	
	public void closeSession(Session session) {
		if (session != null && session.isOpen()) {
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("Error closing session" + e);
			}
		}
	}
	
	public void commitTransaction(Session session) {
		if (session != null && !(session.getTransaction().getStatus() != TransactionStatus.COMMITTED)) {
			session.getTransaction().commit();
		}
	}
	
	public void rollBackTransaction(Session session) {
		if (session != null && !(session.getTransaction().getStatus() != TransactionStatus.ROLLED_BACK)) {
			session.getTransaction().rollback();
		}
	}
}

package hibernateexample.DAO;

import org.hibernate.Session;

import hibernateexample.TO.EmployeeTO;
import hibernateexample.common.HibernateDAO;

public class EmployeeDAO extends HibernateDAO{
	public EmployeeDAO(Session session) {
		super(session);
	}

	public void createEmployee(EmployeeTO employeeTO) throws Exception{
		System.out.println("Entering createuseraccess");
		try {
			if(employeeTO.getId() > 0) {
				attachDirty(employeeTO);
			} else{
				persist(employeeTO);
			}
		} catch (RuntimeException ex) {
	      System.out.println("Exception occured" + ex);
		} finally {
			System.out.println("Exiting createuseraccess");
		}
	}
}

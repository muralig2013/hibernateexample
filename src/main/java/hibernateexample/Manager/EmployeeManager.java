package hibernateexample.Manager;

import org.hibernate.Session;

import hibernateexample.DAO.EmployeeDAO;
import hibernateexample.TO.EmployeeTO;
import hibernateexample.common.HibernateManager;

public class EmployeeManager extends HibernateManager{
	public void createEmployee(EmployeeTO employeeTO) throws Exception {
		Session session = null;
		try {
			session = initTransaction();
			EmployeeDAO employeeDAO = new EmployeeDAO(session);
			employeeDAO.createEmployee(employeeTO);
			commitTransaction(session);
		} catch (Exception e) {
			rollBackTransaction(session);
		} finally {
			closeSession(session);
		}
	}
}

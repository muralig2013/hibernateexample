package hibernateexample.resourcehelper;

import hibernateexample.Manager.EmployeeManager;
import hibernateexample.TO.EmployeeTO;

public class EmployeeResourceHelper {
	public static String create() {
		EmployeeTO employeeTO = new EmployeeTO("Prasanth", 25);
		EmployeeManager employeeManager = new EmployeeManager();
		try {
			employeeManager.createEmployee(employeeTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Employee Created";
	}
}

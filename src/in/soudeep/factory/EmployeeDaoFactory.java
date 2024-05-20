package in.soudeep.factory;

import in.soudeep.dao.EmployeeDaoImpl;
import in.soudeep.dao.IEmployeeDao;

public class EmployeeDaoFactory {
	private static IEmployeeDao employeeDao = null;
	
	private EmployeeDaoFactory() {}
	
	public static IEmployeeDao getEmployeedao() {
		if (employeeDao == null) {
			employeeDao = new EmployeeDaoImpl();
		}
		return employeeDao;
	}
}

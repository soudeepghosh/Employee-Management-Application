package in.soudeep.factory;

import in.soudeep.service.EmployeeServiceImpl;
import in.soudeep.service.IEmployeeService;

public class EmployeeServiceFactory {
	private EmployeeServiceFactory() {}
	
	private static IEmployeeService employeeService = null;
	
	public static IEmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
	
}

package in.soudeep.factory;

import in.soudeep.controller.EmployeeControllerImpl;
import in.soudeep.controller.IEmployeeController;

public class EmployeeControllerFactory {
	private EmployeeControllerFactory() {}
	
	private static IEmployeeController employeeController = null;
	
	public static IEmployeeController getEmployeeController() {
		if (employeeController == null) {
			employeeController = new EmployeeControllerImpl();
		}
		return employeeController;
	}
}

package in.soudeep.controller;

import in.soudeep.dataobjects.Employee;
import in.soudeep.dataobjects.EmployeeVo;
import in.soudeep.factory.EmployeeServiceFactory;
import in.soudeep.service.IEmployeeService;

public class EmployeeControllerImpl implements IEmployeeController {

	IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
	

	@Override
	public String insertRecord(EmployeeVo empVo) {
		Employee emp = new Employee();
		emp.setEname(empVo.getEname());
		emp.setEage(Integer.parseInt(empVo.getEage()));
		emp.setEsal(Long.parseLong(empVo.getEsal()));
		emp.setCompany(empVo.getCompany());
		
		return employeeService.insertRecord(emp);
	}


	@Override
	public EmployeeVo readRecord(String eid) {
		Employee emp = employeeService.readRecord(Integer.parseInt(eid));
		EmployeeVo empVo = null;
		if (emp == null) {
			return empVo;
		} else {
			empVo = new EmployeeVo();
			empVo.setEid(emp.getEid().toString());
			empVo.setEname(emp.getEname());
			empVo.setEage(emp.getEage().toString());
			empVo.setEsal(emp.getEsal().toString());
			empVo.setCompany(emp.getCompany());
		}
		
		
		
		return empVo;
	}


	@Override
	public String updateRecord(EmployeeVo empVo) {
		Employee emp = new Employee();
		emp.setEid(Integer.parseInt(empVo.getEid()));
		emp.setEname(empVo.getEname());
		emp.setEage(Integer.parseInt(empVo.getEage()));
		emp.setEsal(Long.parseLong(empVo.getEsal()));
		emp.setCompany(empVo.getCompany());
		
		return employeeService.updateRecord(emp);
	}


	@Override
	public String deleteRecord(String eid) {
		return employeeService.deleteRecord(Integer.parseInt(eid));
	}

}

package in.soudeep.service;

import in.soudeep.dao.IEmployeeDao;
import in.soudeep.dataobjects.Employee;
import in.soudeep.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDao employeeDao = EmployeeDaoFactory.getEmployeedao();
	
	@Override
	public String insertRecord(Employee employee) {
		return employeeDao.insertRecord(employee);
	}

	@Override
	public Employee readRecord(Integer eid) {
		return employeeDao.readRecord(eid);
	}

	@Override
	public String updateRecord(Employee employee) {
		return employeeDao.updateRecord(employee);
	}

	@Override
	public String deleteRecord(Integer eid) {
		return employeeDao.deleteRecord(eid);
	}

}

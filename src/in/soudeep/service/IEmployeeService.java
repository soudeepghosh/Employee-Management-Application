package in.soudeep.service;

import in.soudeep.dataobjects.Employee;

public interface IEmployeeService {
	public String insertRecord(Employee employee);
	public Employee readRecord(Integer eid);
	public String updateRecord(Employee employee);
	public String deleteRecord(Integer eid);
}

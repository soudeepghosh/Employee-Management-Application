package in.soudeep.controller;


import in.soudeep.dataobjects.EmployeeVo;

public interface IEmployeeController {
	public String insertRecord(EmployeeVo empVo);
	public EmployeeVo readRecord(String eid);
	public String updateRecord(EmployeeVo empVo);
	public String deleteRecord(String eid);
}

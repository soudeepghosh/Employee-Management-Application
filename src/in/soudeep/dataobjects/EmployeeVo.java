package in.soudeep.dataobjects;

import java.io.Serializable;

public class EmployeeVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String eid;
	private String ename;
	private String eage;
	private String esal;
	private String company;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEage() {
		return eage;
	}
	public void setEage(String eage) {
		this.eage = eage;
	}
	public String getEsal() {
		return esal;
	}
	public void setEsal(String esal) {
		this.esal = esal;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "EmployeeVo [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", esal=" + esal + ", company="
				+ company + "]";
	}
	
	
}
